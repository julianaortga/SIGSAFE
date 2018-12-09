<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Raza"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Consulta de razas</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<h2>Listado de razas</h2>
			<table id="dataTable" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Tipo de Ave</th>
						<th width="30%">Acción</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Tipo de Ave</th>
						<th>Acción</th>
					</tr>
				</tfoot>
				<tbody>
					<%
						for (Raza r : (List<Raza>) request.getAttribute("lista")) {
					%>
					<tr>
						<th><%=r.getIdRaza()%></th>
						<th><%=r.getNombre()%></th>
						<th><%=r.getTipoAveBean().getNombre()%></th>
						<th><a href="raza?seleccion=1&id=<%=r.getIdRaza()%>"
							class="btn bdrs-10p btn-outline-danger">Modificar</a> <a
							href="raza?seleccion=5&id=<%=r.getIdRaza()%>"
							class="btn bdrs-10p btn-danger">Eliminar</a></th>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="../util/footer.jspf"%>