package treasure.hunt.Exception;


/**
 * RunTime exception to avoid bad parameters in inputFile
 *
 * @author  LE BOITEUX Maximilien
 * @version 1.0
 * @since   2021-06-6
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}
