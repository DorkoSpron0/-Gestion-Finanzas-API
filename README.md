# Documento de Requisitos - Aplicación de Gestión Personal de Finanzas
>Idea Central del Proyecto
Desarrollar una aplicación web de gestión personal de finanzas, enfocada en usuarios individuales que
desean llevar un control detallado de sus ingresos, egresos, categorías de gasto, metas de ahorro y análisis
de su comportamiento financiero.
Tecnologías Base Recomendadas- Backend: Java 17+, Spring Boot, Spring Data JPA, Spring Security- Base de datos: PostgreSQL o MySQL- Autenticación: JWT- Documentación: Swagger/OpenAPI- Control de versiones: Git- Testing: JUnit 5, Mockito- CI/CD: GitHub Actions- Despliegue: Docker
---

## Requisitos Funcionales
1. Autenticación y Gestión de Usuario:- Registro, inicio de sesión, recuperación de contraseña
2. Módulo de Cuentas:- Crear cuentas bancarias o virtuales- Editar/eliminar cuentas- Asociar movimientos a cuentas
3. Módulo de Movimientos:- Crear, editar, eliminar, consultar movimientos y balances
4. Categorías:- Crear, listar, editar y eliminar categorías
5. Metas Financieras:- Crear metas, asociar movimientos, ver progreso
6. Reportes y Visualizaciones:- Gráficos, exportaciones, resúmenes
   Documento de Requisitos - Aplicación de Gestión Personal de Finanzas
7. Notificaciones (opcional):- Alertas de metas o sobrepresupuesto

## Requisitos No Funcionales
1. Escalabilidad- Seguridad con JWT y HTTPS
2. Rendimiento: < 300 ms- Disponibilidad 99.5%- Mantenibilidad modular 
3. Internacionalización preparada

---
   
## Modelo de Datos Conceptual
1. Usuario: ID, nombre, correo, contraseña, fecha de registro (1:N movimientos, categorías, metas, cuentas)
2. Cuenta: ID, nombre, tipo (bancaria, virtual, efectivo), saldo actual, activa (booleano) (N:1 usuario, 1:N
   movimientos)
3. Movimiento: ID, fecha, tipo, monto, descripción (N:1 usuario, categoría, cuenta, meta)
4. Categoría: ID, nombre, tipo, personalizada (N:1 usuario, 1:N movimientos)
5. MetaFinanciera: ID, nombre, monto objetivo, fecha límite, estado (N:1 usuario, 1:N movimientos)
   
## Casos de Uso Relevantes
- Registrar usuario nuevo
- Iniciar sesión
- Crear y administrar cuentas
- Agregar movimiento
- Consultar historial
- Administrar categorías
- Crear y consultar metas
- Ver reportes
- Exportar movimientos
- Recuperar contraseña

---
## Endpoints REST Sugeridos
   ### Autenticación:
    - POST /api/auth/register
    - POST /api/auth/login- POST /api/auth/forgot-password
   ### Cuentas:
    - GET/POST/PUT/DELETE /api/accounts
   ### Movimientos:
    - GET/POST/PUT/DELETE /api/movements
    - GET /api/movements/summary
   ### Categorías:
    - GET/POST/PUT/DELETE /api/categories
   ### Metas:
    - GET/POST/PUT/DELETE /api/goals
   ### Reportes:
    - GET /api/reports/overview
    - GET /api/reports/export

---

## Recomendaciones Adicionales
1. Testing:- Unit e integración
2. Documentación:- Swagger y README claro
3. Documento de Requisitos - Aplicación de Gestión Personal de Finanzas
4. Seguridad:- JWT, cifrado, roles
5. CI/CD:- GitHub Actions, Docker
6. Escalabilidad:- Modularidad, separación de capas, base de datos optimizada