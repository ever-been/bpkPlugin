package cz.cuni.mff.d3s.been.bpkplugin;

/**
 * Used when BPK cannot be generated from some reason.
 * 
 * @author Tadeas Palusga
 * 
 */
class GeneratorException extends Exception {

	/**
	 * SERIAL VERSION UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructs new {@link GeneratorException}
	 * 
	 * @param cause
	 *          cause of the exception
	 */
	public GeneratorException(Throwable cause) {
		super(cause);
	}

	/**
	 * constructs new {@link GeneratorException}
	 * 
	 * @param message
	 *          description of cause
	 */
	public GeneratorException(String message) {
		super(message);
	}

	/**
	 * constructs new {@link GeneratorException}
	 * 
	 * @param message
	 *          description of cause
	 * @param cause
	 *          cause of the exception
	 */
	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
	}

}
