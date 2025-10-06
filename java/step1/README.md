## Paso 1. De procedural a OOP

### ¿Por qué la OOP mejora la mantenibilidad y escalabilidad?

1. **Separación de responsabilidades:** Cada clase se enfoca en una única tarea (SRP), lo que reduce el acoplamiento y facilita la mantenibilidad y las pruebas unitarias.

2. **Encapsulación:** El estado interno (por ejemplo, el balance) está protegido y solo puede modificarse mediante métodos controlados, centralizando las reglas de negocio en la entidad `Account`.

3. **Interfases e inyección de dependencias:** Componentes como `TransactionLogger` y `Notifier` se abstraen mediante interfaces, permitiendo cambiar su implementación (archivo, base de datos, servicio externo) sin afectar la lógica del dominio.

4. **Extensibilidad:** Es sencillo agregar nuevos tipos de cuentas (por ejemplo, `SavingsAccount`, `CheckingAccount` con reglas específicas) extendiendo o componiendo `Account` sin modificar `TransferService`. Para nuevos tipos de transferencias (por ejemplo, internacional, con comisiones), se pueden introducir estrategias (`TransferStrategy`) y aplicarlas en `TransferService`.

5. **Testabilidad:** Es posible simular (`mockear`) las dependencias como `TransactionLogger` y `Notifier`, permitiendo probar `TransferService` de forma aislada y confiable.
