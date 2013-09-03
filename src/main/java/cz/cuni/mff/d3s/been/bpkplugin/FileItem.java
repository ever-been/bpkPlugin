package cz.cuni.mff.d3s.been.bpkplugin;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.maven.plugins.annotations.Parameter;

import cz.cuni.mff.d3s.been.bpk.BpkNames;
import cz.cuni.mff.d3s.been.util.FileToArchive;

/**
 * Represents wildcard or file which will be added into generated BPK bundle
 * into "files" folder.
 * 
 * @author donarus
 * 
 */
public final class FileItem {

	/**
	 * When specified, no wildcard will be used, but this file will be added
	 * directly into root of generated bpk archive.
	 */
	@Parameter
	private File file;

	/**
	 * Files will be searched in {@link #wildcardWorkingDirectory} by this
	 * wildcard.
	 */
	@Parameter
	private String wildcard;

	/**
	 * When {@link #wildcard} is specified, files will be searched in this
	 * directory.
	 */
	@Parameter
	private File wildcardWorkingDirectory;

	/**
	 * Create list of files, which will be added to archive. Depending on
	 * parameters, single file or files found by specified {@link #wildcard} in
	 * {@link #wildcardWorkingDirectory} will be added.
	 * 
	 * @return files which will be added to archive
	 */
	public List<FileToArchive> getFilesToArchive() {
		String folderName = BpkNames.FILES_DIR;
		List<File> files = collectFilesForAdding();

		List<FileToArchive> filesToArchive = new ArrayList();
		for (File f : files) {
			String nameInBpk = String.format("%s%s%s", folderName, File.separator, f.getName());
			filesToArchive.add(new FileToArchive(nameInBpk, f));
		}
		return filesToArchive;
	}

	private List<File> collectFilesForAdding() {
		List<File> files = new ArrayList();
		if (file != null) {
			files.add(file);
		} else {
			FileFilter filter = new WildcardFileFilter(wildcard);
			files.addAll(Arrays.asList(wildcardWorkingDirectory.listFiles(filter)));
		}
		return files;
	}

}
