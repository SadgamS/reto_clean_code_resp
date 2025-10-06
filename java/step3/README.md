# Modelo de dominio
## Resumen de la carpeta step3

Esta carpeta contiene el modelo de dominio para el sistema de pedidos y carrito de compras, incluyendo:

- Clases Java: `Carrito`, `Cliente`, `EstadoPedido`, `ItemCarrito`, `Pago`, `Pedido`, `Producto`, `Descuento`.
- Diagrama de entidades y relaciones en formato Mermaid (`diagram.mmd`).
- Imagen PNG generada del diagrama (`diagram.png`).
- Este README con el diagrama y notas explicativas.

El objetivo es mostrar la estructura y relaciones principales entre las entidades del dominio, útil para entender y documentar el diseño del sistema.

```mermaid
erDiagram
    PRODUCTO {
        String id;
        String nombre;
        double precio;
        int stock;
    }

    ITEM_CARRITO {
        Producto producto;
        int cantidad;
        %% subtotal = producto.precio * cantidad
    }

    CARRITO {
        %% contiene una lista de ITEM_CARRITO
        %% calcula total sumando subtotales
    }

    CLIENTE {
        String id;
        String nombre;
        String tipo;
    }

    PEDIDO {
        String id;
        Cliente cliente;
        List<ItemCarrito> items;
        EstadoPedido estado;
        BigDecimal total;

        %% calcularTotal: suma los subtotales de los items
        calcularTotal() : BigDecimal

        %% confirmar: cambia estado de PENDIENTE a CONFIRMADO
        confirmar()

        %% marcarPagado: cambia estado de CONFIRMADO a PAGADO
        marcarPagado()
    }

    PAGO {
        String id;
        Pedido pedido;
        BigDecimal monto;
        String metodo;
    }

    %% Relaciones corregidas
    PRODUCTO ||--o{ ITEM_CARRITO : "compone"
    ITEM_CARRITO }o--|| CARRITO : "pertenece a"
    ITEM_CARRITO }o--|| PEDIDO : "pertenece a"
    CLIENTE ||--o{ PEDIDO : "realiza"
    PEDIDO ||--o{ PAGO : "tiene"

```

### Notas:

- `EstadoPedido` es un enum con valores: PENDIENTE, CONFIRMADO, PAGADO, ENVIADO, ENTREGADO, CANCELADO.
- `ItemCarrito` se usa tanto dentro de `Carrito` como en `Pedido` (los items pueden transferirse o reutilizarse según la implementación).
- `Descuento` puede estar asociado al cliente y/o al pedido, permitiendo reglas flexibles de promoción.
- Se agregaron atributos relevantes como fecha, dirección y referencia para mayor trazabilidad.
- El subtotal de `ItemCarrito` se calcula automáticamente.
- El modelo contempla categorías y descripciones para productos.

# Lenguaje ubicuo

**Producto**  
Artículo disponible en el catálogo, con precio, nombre, descripción y categoría.

**Carrito**  
Contenedor temporal de productos antes de confirmar la compra. Tiene fecha de creación y total calculado.

**ItemCarrito**  
Asociación entre un producto y su cantidad dentro del carrito o pedido. Incluye subtotal.

**Pedido**  
Representa la orden de compra creada a partir de un carrito confirmado. Incluye dirección de envío, fecha y estado.

**Cliente**  
Usuario que realiza compras. Tiene tipo, email y dirección. El tipo influye en descuentos.

**Pago**  
Transacción financiera para completar un pedido confirmado. Incluye método, fecha y referencia.

**EstadoPedido**  
Puede ser PENDIENTE, CONFIRMADO, PAGADO, ENVIADO, ENTREGADO o CANCELADO.

**Total**  
Suma del valor de los productos del pedido, considerando descuentos.

**Descuento**  
Reducción de precio aplicada según el tipo de cliente o promociones activas. Puede ser porcentaje o monto fijo.
