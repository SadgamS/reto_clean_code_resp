# Patrones

## Principios SOLID y su Aplicación

| Principio                           | Aplicación                                                                               |
| ----------------------------------- | ---------------------------------------------------------------------------------------- |
| **SRP (Responsabilidad Única)**     | Cada clase tiene una sola tarea (generar, guardar o notificar).                          |
| **OCP (Abierto/Cerrado)**           | Se puede agregar un `GeneradorInformePDF` sin tocar el servicio.                         |
| **LSP (Sustitución de Liskov)**     | Cualquier implementación de `GeneradorInforme` puede reemplazarse sin romper el sistema. |
| **ISP (Segregación de Interfaces)** | Las interfaces son pequeñas y enfocadas.                                                 |
| **DIP (Inversión de Dependencias)** | El servicio depende de abstracciones (interfaces), no de clases concretas.               |

---

## Propuesta de arquitectura

Te muestro las dos opciones y luego la elegida para el módulo de pedidos:

### Opción 1: Arquitectura MVC

Ideal si todo vive en un mismo monolito (por ejemplo, aplicación web con Spring Boot).

```
┌─────────────────────┐
│   Controller (API)  │  ← Entrada HTTP
└────────┬────────────┘
         │
┌────────▼─────────┐
│ Service (Caso de │  ← Lógica de negocio, usa DDD
│ uso + Dominio)   │
└────────┬─────────┘
         │
┌────────▼──────────┐
│ Repository / DAO  │  ← Acceso a datos (infraestructura)
└────────────────────┘
```

**Ventajas:**

- Simple de implementar.
- Buena separación de capas.
- Menor sobrecarga operacional.

---

### Opción 2: Arquitectura Microservicios (recomendada)

Separar el e-commerce en microservicios:

| Microservicio | Responsabilidad                                   | API              |
| ------------- | ------------------------------------------------- | ---------------- |
| **Catálogo**  | CRUD de productos y categorías                    | `/api/productos` |
| **Pedidos**   | Crear, confirmar y listar pedidos                 | `/api/pedidos`   |
| **Pagos**     | Procesar pagos y registrar transacciones          | `/api/pagos`     |
| **Clientes**  | Gestión de clientes y sus tipos (para descuentos) | `/api/clientes`  |

**Comunicación entre ellos:**

- Sincronización mediante mensajería (RabbitMQ, Kafka) o REST APIs.
- Cada servicio posee su propia base de datos.

**Ejemplo de flujo:**

`Cliente → Servicio Pedidos → Evento "Pedido Confirmado" → Servicio Pagos → Actualiza estado → Notifica al cliente.`

**Ventajas:**

- Alta escalabilidad y mantenibilidad.
- Despliegue independiente por servicio.
- Encapsula completamente cada contexto delimitado (DDD).
