package cz.cuni.mff.d3s.been.bpkplugin;

import java.io.File;
import java.util.Collection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.maven.artifact.Artifact;

import cz.cuni.mff.d3s.been.bpk.BpkIdentifier;

/**
 * Simple POJO object representing configuration obtained from Maven's pom.xml
 * 
 * @author Tadeas Palusga
 * 
 */
public class Configuration {

	/**
	 * group id of the BPK
	 */
	public String groupId;

	/**
	 * id of the BPK
	 */
	public String bpkId;

	/**
	 * version of the BPK
	 */
	public String version;

	/**
	 * final name of the generated BPK file
	 */
	public String finalName;

	/**
	 * binary to be used as main task/benchmark executable for native tasks
	 */
	public File binary;

	/**
	 * directory to which the BPK package will be generated
	 */
	public File buildDirectory;

	/**
	 * jar file with task/benchmark implementation which will be used for java
	 * tasks
	 */
	public File packageJarFile;

	/**
	 * files which should be stored in directory "files" within generated BPK
	 */
	public Collection<FileItem> filesToArchive;

	/**
	 * Collection of libraries needed by this BPK package.
	 */
	public Collection<Artifact> artifacts;

	/**
	 * Collection of BPK dependencies of generated BPK package.
	 */
	public Collection<BpkIdentifier> bpkDependencies;

	/**
	 * collection of task descriptor files which should be packed in result BPK
	 * package
	 */
	public File[] taskDescriptors;

	/**
	 * collection of task context descriptor files which should be packed in
	 * result BPK package
	 */
	public File[] taskContextDescriptors;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
