<%@include file="../util/header.jspf"%>
<%@ page import="java.util.List"%>
<%@ page import="model.LineaG"%>
<div id="mainContent" class="main-content bgc-grey-100">
	<div class="row text-center justify-content-md-center">
		<div class="col-12">
			<h2>Finca Experimental San Pablo - UFPS</h2>
			<h3>Consulta de Lineas Gen�ticas</h3>
			<hr>
		</div>
		<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">
			<h2>Listado de Lineas Gen�ticas</h2>
			<table id="dataTable" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Observaci�n</th>
						<th>Tipo de Ave</th>
						<th width="30%">Acci�n</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Observaci�n</th>
						<th>Tipo de Ave</th>
						<th>Acci�n</th>
					</tr>
				</tfoot>
				<tbody>
					<%
						for (LineaG lg : (List<LineaG>) request.getAttribute("lista")) {
					%>
					<tr>
						<th><%=lg.getIdLineaG()%></th>
						<th><%=lg.getNombre()%></th>
						<th><%=lg.getObservacion()%></th>
						<th><%=lg.getTipoAveBean().getNombre()%></th>
						<th><a
							href="linea-genetica?seleccion=1&id=<%=lg.getIdLineaG()%>"
							class="btn bdrs-10p btn-outline-danger">Modificar</a> <a
							href="linea-genetica?seleccion=5&id=<%=lg.getIdLineaG()%>"
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