<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proveedores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<section class="container">
    <h1><strong>Ingresa tus datos: </strong></h1>
    <br>
    <br>
    <div class="row">
        <form action="providers?action=insert" method="POST">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" aria-label="Nombre" required>

            <label for="rut" class="form-label">Rut</label>
            <input type="text" class="form-control" name="rut"  id="rut" placeholder="Rut" aria-label="Rut" required>

            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" class="form-control" name="direccion" id="direccion" placeholder="Dirección" aria-label="Dirección" required>

            <label for="correo" class="form-label">Email</label>
            <input type="text" class="form-control" name="correo" id="correo" placeholder="Email" aria-label="Email" required>

            <label for="telefono" class="form-label">Teléfono</label>
            <input type="text" class="form-control" name="telefono" id="telefono" placeholder="Teléfono" aria-label="Teléfono" required>

            <label for="contacto" class="form-label">Contácto</label>
            <input type="text" class="form-control" name="contacto" id="contacto" placeholder="Contácto" aria-label="Contácto" required>

            <label for="telefono_contacto" class="form-label">Número de Contacto</label>
            <input type="text" class="form-control" name="telefono_contacto" id="telefono_contacto" placeholder="Número de Contácto" aria-label="Número de Contácto" required>
            <br>
            <button type="submit" class="btn btn-primary btn-lg" value="insertProvider">Ingresar</button>
        </form>
    </div>
    <br>
    <c:if test="${usuarioCreado != null}">
        <c:choose>
            <c:when test="${usuarioCreado}">
                <div class="alert alert-success">${respMensaje}</div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger">${respMensaje}</div>
            </c:otherwise>
        </c:choose>
    </c:if>

</section>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>
</body>
</html>