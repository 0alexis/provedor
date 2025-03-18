package despacho.proveedor.provedor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        // Maneja excepciones genéricas de tipo RuntimeException
        if (ex.getMessage().contains("Producto no encontrado")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } else if (ex.getMessage().contains("Stock insuficiente")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        // Por defecto, devuelve un 400 para otras excepciones no manejadas específicamente
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        // Maneja cualquier otra excepción no capturada específicamente
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor: " + ex.getMessage());
    }
}