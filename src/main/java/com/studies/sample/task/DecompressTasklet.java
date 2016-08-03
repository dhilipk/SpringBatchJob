package com.studies.sample.task;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

@Getter
@Setter
public class DecompressTasklet implements Tasklet {
	private Resource inputResource;
	private String targetDirectory;
	private String targetFile;

	@Override
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(inputResource.getInputStream()));
        File targetDirectoryAsFile = new File(targetDirectory);
        if(!targetDirectoryAsFile.exists()) {
            FileUtils.forceMkdir(targetDirectoryAsFile);
        }
        File target = new File(targetDirectory,targetFile);
        BufferedOutputStream dest = null;
        while(zis.getNextEntry() != null) {
            if(!target.exists()) {
                target.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(target);
            dest = new BufferedOutputStream(fos);
            IOUtils.copy(zis,dest);
            dest.flush();
            dest.close();
        }
        zis.close();
        if(!target.exists()) {
            throw new IllegalStateException("Could not decompress anything from the archive!");
        }
        return RepeatStatus.FINISHED;
    }

}
