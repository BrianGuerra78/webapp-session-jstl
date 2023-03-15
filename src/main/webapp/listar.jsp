<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />

<h3>${title}</h3>

<c:if test="${username.present}">
<div class="alert alert-info">Hola <c:out value="${username.get()}"/>, bienvenido!</div>
<a class="btn btn-primary my-2" href="<c:out value="${pageContext.request.contextPath}" />/productos/form">crear [+]</a>
</c:if>

<table class="table table-hover table-striped">
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>tipo</th>

        <c:if test="${username.present}">
        <th>precio</th>
        <th>agregar</th>
        <th>editar</th>
        <th>eliminar</th>
        </c:if>

    </tr>

    <c:forEach items="${productos}" var="p">
    <tr>
        <td><c:out value="${p.id}" /></td>
        <td><c:out value="${p.nombre}" /></td>
        <td><c:out value="${p.categoria.nombre}" /></td>
        <c:if test="${username.present}">
        <td><c:out value="${p.precio}" /></td>
        <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/carro/agregar?id=<c:out value="${p.id}" />">agregar al carro</a></td>
        <td><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/productos/form?id=<c:out value="${p.id}" />">editar</a></td>
        <td><a class="btn btn-sm btn-danger" onclick="return confirm('esta seguro que desea eliminar?');"
        href="${pageContext.request.contextPath}/productos/eliminar?id=<c:out value="${p.id}" />">eliminar</a></td>
       </c:if>
    </tr>
    </c:forEach>

</table>
<p>${applicationScope.mensaje}</p>
<p>${requestScope.mensaje}</p>
<jsp:include page="layout/footer.jsp" />