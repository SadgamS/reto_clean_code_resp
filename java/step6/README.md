Paso 6. Arquitectura limpia

## 1. Diseño por capas — Arquitectura limpia

La arquitectura limpia separa responsabilidades y facilita el mantenimiento. Se organiza en 4 capas principales:

### a) Entidades (Domain Layer)
- Contiene las reglas de negocio y conceptos centrales.
- Independiente de frameworks externos.
- Ejemplo: Clases en `domain` como `User`, `Order`, `Product`.
- No depende de otras capas.

### b) Casos de Uso (Application Layer)
- Orquesta operaciones de negocio usando entidades.
- Define el flujo para casos de uso específicos.
- Encapsula lógica de aplicación, no de dominio.
- No depende de frameworks externos.

### c) Adaptadores de interfaz (Interface Adapters)
- Adapta datos entre el dominio y el mundo externo.
- Incluye controladores, gateways, repositorios, DTOs.
- Traduce datos entre formatos externos e internos.

### d) Frameworks y Drivers (Infrastructure Layer)
- Implementa detalles concretos para interactuar con frameworks, bases de datos, APIs.
- Incluye repositorios, configuración de frameworks, clientes HTTP.
- Solo esta capa depende de las demás.


## Ejemplo de estructura de carpetas

```plaintext
src/
├── domain/
│   ├── User.java
│   └── Product.java
├── application/
│   ├── CreateOrderUseCase.java
│   └── UserService.java
├── adapters/
│   ├── controllers/
│   │   └── UserController.java
│   └── repositories/
│       └── UserRepository.java
└── infrastructure/
    ├── persistence/
    │   └── UserRepositoryImpl.java
    └── config/
        └── AppConfig.java
```