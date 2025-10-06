## Aplicación KISS, DRY y YAGNI aquí

**KISS:** `ReporteService` se encarga únicamente de la orquestación; las tareas concretas (generar, guardar, notificar) son simples y están desacopladas.

**DRY:** El formateo del contenido está centralizado en `GeneradorReporteCSV`. Si se requiere otro tipo de reporte, se reutiliza la lógica existente o se extiende mediante otra implementación.

**YAGNI:** No se implementan múltiples canales de notificación o almacenamiento antes de que sean necesarios. La arquitectura permite añadirlos cuando se requieran, evitando complejidad innecesaria. Se utiliza inyección de dependencias para facilitar futuras extensiones sin implementarlas de antemano.

---

## Ensayo breve: Riesgos de una arquitectura "Big Ball of Mud" y cómo la refactorización ayuda

### Riesgos de Big Ball of Mud

- **Alta deuda técnica:** El código sin estructura aumenta el coste de cambios y la probabilidad de errores.
- **Difícil de entender y mantener:** Los nuevos integrantes tardan más en ser productivos; el conocimiento está disperso.
- **Escasa testabilidad:** La mezcla de lógica y efectos secundarios (I/O, redes) dificulta las pruebas unitarias, lo que puede ocultar regresiones.
- **Despliegues riesgosos:** Cambios pequeños pueden afectar áreas no relacionadas, incrementando el riesgo de caídas.
- **Escalabilidad limitada:** El fuerte acoplamiento y la mezcla de responsabilidades impiden escalar partes específicas.

### Cómo la refactorización reduce esos riesgos

- **Separación de responsabilidades:** Dividir en clases e interfaces reduce el acoplamiento y facilita cambios locales sin efectos colaterales.
- **Inyección de dependencias:** Permite sustituir implementaciones (por ejemplo, pasar de almacenamiento local a S3) sin modificar la lógica de negocio.
- **Aumenta testabilidad:** Al poder mockear repositorios y notificadores, las pruebas unitarias cubren la lógica de orquestación y formato sin depender de I/O.
- **Mejor observabilidad y mantenimiento:** El uso de adaptadores claros (infraestructura) y contratos (interfaces) facilita la introducción de logging, métricas y monitoreo.
- **Evolución segura:** Agregar nuevas características (por ejemplo, reporte en PDF o envío a servicios externos) se logra implementando nuevas clases y registrándolas en el wiring, sin modificar la lógica existente (cumpliendo OCP).
