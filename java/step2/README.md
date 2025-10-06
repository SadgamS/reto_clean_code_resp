## Paso 2. TDD y diseño emergente

### Reflexión sobre YAGNI

El principio “You Aren’t Gonna Need It” (YAGNI) indica que no debemos implementar funcionalidades o tipos de clientes futuros que aún no han sido requeridos.

En este contexto, podríamos sentir la tentación de agregar tipos como STUDENT, CORPORATE o WHOLESALE. Sin embargo, hacerlo sin una necesidad real incrementa la complejidad, el esfuerzo de mantenimiento y el riesgo de errores.

Aplicando YAGNI, solo mantenemos los tipos existentes (REGULAR, VIP, PREMIUM) y dejamos espacio para extender el mapa cuando surja un requerimiento real.
