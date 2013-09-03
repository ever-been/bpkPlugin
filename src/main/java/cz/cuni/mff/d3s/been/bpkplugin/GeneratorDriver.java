package cz.cuni.mff.d3s.been.bpkplugin;

import org.apache.maven.plugin.logging.Log;

/**
 * This class is responsible for selecting correct generator (native or java)
 * for the result BPK.
 * 
 * @author Tadeas Palusga
 * 
 */
class GeneratorDriver {

	private Log log;

	/**
	 * Constructs new generator driver
	 * 
	 * @param log
	 *          logger through which the user will be informed about execution
	 *          progress and/or failures
	 */
	public GeneratorDriver(Log log) {
		this.log = log;
	}

	/**
	 * selects correct generator (java or native) and starts generation process
	 * 
	 * @param runtimeTypeName
	 *          name of the target runtime (valid values are 'JAVA' or 'NATIVE')
	 * @param configuration
	 *          configuration from user's pom.xml
	 * @throws ConfigurationException
	 *           when runtime type is not correctly defined
	 * @throws GeneratorException
	 *           when package could not be generated from some reason
	 */
	public
			void
			generate(String runtimeTypeName, Configuration configuration) throws ConfigurationException, GeneratorException {
		selectCorrectGenerator(runtimeTypeName).generate(configuration);
	}

	GeneratorImpl selectCorrectGenerator(String runtimeTypeName) throws ConfigurationException {
		RuntimeType runtimeType = RuntimeType.determine(runtimeTypeName);
		if (runtimeType == null) {
			throw new ConfigurationException(String.format("Runtime type '%s' is not defined", runtimeTypeName));
		}
		switch (runtimeType) {
			case JAVA:
				return new JavaGenerator(log);
			case NATIVE:
				return new NativeGenerator(log);
			default:
				// should not happen but just for sure
				throw new IllegalArgumentException(String.format(
						"BPK generator for runtime type '%s' is not implemented",
						runtimeTypeName));
		}
	}

}
