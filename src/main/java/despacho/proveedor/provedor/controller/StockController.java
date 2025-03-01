//package despacho.proveedor.provedor.controller;
//
//
//import despacho.proveedor.provedor.service.StockService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/stock")
//public class StockController {
//
//    @Autowired
//    private StockService stockService;
//
//    @GetMapping("/{productoId}")
//    public ResponseEntity<String> verificarStock(
//            @PathVariable Long productoId,
//            @RequestParam int cantidad) {
//        boolean disponible = stockService.verificarStock(productoId, cantidad);
//        if (disponible) {
//            return ResponseEntity.ok("Stock disponible: " + productoId);
//        } else {
//            return ResponseEntity.badRequest().body("Stock insuficiente para el producto: " + productoId);
//        }
//    }
//
//    @PostMapping("/reservar/{productoId}")
//    public ResponseEntity<String> reservarStock(
//            @PathVariable Long productoId,
//            @RequestParam int cantidad) {
//        try {
//            stockService.reservarStock(productoId, cantidad);
//            return ResponseEntity.ok("Stock reservado exitosamente para el producto: " + productoId);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}

package despacho.proveedor.provedor.controller;

import despacho.proveedor.provedor.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @Operation(summary = "Verificar disponibilidad de stock", description = "Verifica si hay suficiente stock para un producto dado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock disponible",
                    content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
            @ApiResponse(responseCode = "400", description = "Stock insuficiente",
                    content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content(mediaType = "text/plain", schema = @Schema(type = "string")))
    })
    @GetMapping("/{productoId}")
    public ResponseEntity<String> verificarStock(
            @Parameter(description = "ID del producto a verificar") @PathVariable Long productoId,
            @Parameter(description = "Cantidad solicitada para verificar") @RequestParam int cantidad) {
        boolean disponible = stockService.verificarStock(productoId, cantidad);
        if (disponible) {
            return ResponseEntity.ok("Stock disponible: " + productoId);
        } else {
            return ResponseEntity.badRequest().body("Stock insuficiente para el producto: " + productoId);
        }
    }

    @Operation(summary = "Reservar stock para un producto", description = "Reserva una cantidad de stock para un producto y actualiza el inventario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock reservado exitosamente",
                    content = @Content(mediaType = "text/plain", schema = @Schema(type = "string"))),
            @ApiResponse(responseCode = "400", description = "Error al reservar stock (stock insuficiente o producto no encontrado)",
                    content = @Content(mediaType = "text/plain", schema = @Schema(type = "string")))
    })
    @PostMapping("/reservar/{productoId}")
    public ResponseEntity<String> reservarStock(
            @Parameter(description = "ID del producto para reservar stock") @PathVariable Long productoId,
            @Parameter(description = "Cantidad a reservar") @RequestParam int cantidad) {
        try {
            stockService.reservarStock(productoId, cantidad);
            return ResponseEntity.ok("Stock reservado exitosamente para el producto: " + productoId);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}