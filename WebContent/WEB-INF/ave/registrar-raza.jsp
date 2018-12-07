<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.TipoAve"%>
<%@ page import="model.Raza"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,shrink-to-fit=no">
<title>SIGSAFE</title>
<link href="resources/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
</head>
<body class="app">
	<div id="loader" class="pos-f h-100vh w-100 bgc-deep-purple-50 z-9">
		<div class="spinner"></div>
	</div>
	<script>
		window.addEventListener('load', function() {
			const loader = document.getElementById('loader');
			setTimeout(function() {
				loader.classList.add('fadeOut');
			}, 3000);
		});
	</script>
	<div>
		<div class="sidebar">
			<div class="sidebar-inner">
				<div class="sidebar-logo">
					<div class="peers ai-c fxw-nw">
						<div class="peer peer-greed">
							<a class="sidebar-link td-n" href="index.jsp">
								<div class="peers ai-c fxw-nw">
									<div class="peer">
										<div id="logo-index" class="logo">
											<img src="resources/img/logoufps.png" alt="">
										</div>
									</div>
									<div class="peer peer-greed">
										<h5 id="texto-navbar" class="lh-1 mB-0 logo-text">Finca
											San Pablo Avícola</h5>
									</div>
								</div>
							</a>
						</div>
						<div class="peer">
							<div class="mobile-toggle sidebar-toggle">
								<a href="" class="td-n"><i class="ti-arrow-circle-left"></i></a>
							</div>
						</div>
					</div>
				</div>
				<ul class="sidebar-menu scrollable pos-r">
					<li class="nav-item mT-30 active"><a class="sidebar-link"
						href="index.jsp"><span class="icon-holder"><i
								class="c-blue-500 fas fa-home"></i> </span><span class="title">Inicio</span></a></li>

					<li class="nav-item"><a class="sidebar-link"
						href="ave?seleccion=1"><span class="icon-holder"><i
								class="c-yellow-500 fas fa-kiwi-bird"></i> </span><span class="title">Aves</span></a></li>

					<li class="nav-item"><a class="sidebar-link"
						href="Lotes/moduloLotes.jsp"><span class="icon-holder"><i
								class="c-green-500 fas fa-warehouse"></i> </span><span class="title">Lotes
								y Galpones</span></a></li>

					<li class="nav-item"><a class="sidebar-link"
						href="Alimentación/moduloAlimentacion.jsp"><span
							class="icon-holder"><i
								class="c-deep-orange-500 fas fa-utensils"></i> </span><span
							class="title">Alimentación</span></a></li>

					<li class="nav-item"><a class="sidebar-link"
						href="Produccion/moduloProduccion.jsp"><span
							class="icon-holder"><i
								class="c-brown-500 far fa-chart-bar"></i> </span><span class="title">Producción</span></a></li>

					<li class="nav-item dropdown"><a class="dropdown-toggle"><span
							class="icon-holder"><i class="c-red-500 fas fa-users-cog"></i>
						</span><span class="title">Usuario</span> <span class="arrow"><i
								class="ti-angle-right"></i></span></a>
						<ul class="dropdown-menu">
							<li><a class="sidebar-link" href="Usuario/consultar.jsp">Consultar</a></li>
							<li><a class="sidebar-link" href="Usuario/registrar.jsp">Registrar</a></li>
						</ul></li>

				</ul>
			</div>
		</div>
		<div class="page-container">
			<div class="header navbar">
				<div class="header-container">
					<ul class="nav-left">
						<li><a id="sidebar-toggle" class="sidebar-toggle"
							href="javascript:void(0);"><i class="ti-menu"></i></a></li>
						<li class="search-box"><a class="search-toggle no-pdd-right"
							href="javascript:void(0);"><i
								class="search-icon ti-search pdd-right-10"></i> <i
								class="search-icon-close ti-close pdd-right-10"></i></a></li>
						<li class="search-input"><input class="form-control"
							type="text" placeholder="Buscar..."></li>
					</ul>
					<ul class="nav-right">


						<li class="dropdown"><a href=""
							class="dropdown-toggle no-after peers fxw-nw ai-c lh-1"
							data-toggle="dropdown">
								<div class="peer mR-10">
									<i class="far fa-user-circle"></i>
								</div>
								<div class="peer">
									<span class="fsz-sm c-grey-900">Aqui va el nombre del
										usuario</span>
								</div>
						</a>
							<ul class="dropdown-menu fsz-sm">
								<li><a href=""
									class="d-b td-n pY-5 bgcH-grey-100 c-grey-700"><i
										class="ti-settings mR-10"></i> <span>Modificar</span></a></li>
								<li><a href=""
									class="d-b td-n pY-5 bgcH-grey-100 c-grey-700"><i
										class="ti-user mR-10"></i> <span>Datos</span></a></li>
								<li><a href=""
									class="d-b td-n pY-5 bgcH-grey-100 c-grey-700"><i
										class="ti-power-off mR-10"></i> <span>Cerrar Sesión</span></a></li>
							</ul></li>
					</ul>
				</div>
			</div>

			<main class="main-content bgc-grey-100">
			<div id="mainContent">
				<div class="row text-center justify-content-md-center">
					<div class="col-12">
						<h2>Finca Experimental San Pablo - UFPS</h2>
						<h3>Registrar raza</h3>
						<hr>
					</div>
					<div class="col-md-10 col-sm-12 bd bgc-white p-20 text-left mT-40">

						<%
							try {
								Raza temporal = (Raza) request.getAttribute("objeto");
								if (temporal != null) {
						%>
						<!-- Actualizar -->
						<form action="ave" method="POST">
							<input type="hidden" value="19" name="seleccion"> <input
								type="hidden" value="<%=temporal.getIdRaza()%>" name="id">
							<div class="form-group">
								<div class="form-group col-md-6">
									<label for="nombre">Nombre de la raza</label> <input
										type="text" class="form-control" name="nombre"
										placeholder="Tipo de ave" value="<%=temporal.getNombre()%>"
										required>
								</div>
							</div>
							<div class="form-group col-md-6">
								<label for="tipoAveBean">Tipo</label> <select name="tipoAveBean"
									class="form-control">
									<option selected="selected"">Seleccionar...</option>
									<%
										List<TipoAve> combo = (List<TipoAve>) request.getAttribute("combo");
												for (TipoAve ta : combo) {
									%>
									<option value="<%=ta.getIdTipoAve()%>"><%=ta.getNombre()%></option>
									<%
										}
									%>
								</select>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-danger">Guardar</button>
								<a type="button" class="btn btn-light">Volver</a>
							</div>

						</form>

						<%
							} else {
						%>
						<!-- Registrar -->

						<form action="ave" method="POST">
							<input type="hidden" value="7" name="seleccion">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="nombre">Nombre de la raza</label> <input
										type="text" class="form-control" name="nombre"
										placeholder="Raza del ave" required>
								</div>
								<div class="form-group col-md-6">
									<label for="tipoAveBean">Tipo</label> <select
										name="tipoAveBean" class="form-control">
										<option selected="selected">Seleccionar...</option>
										<%
											List<TipoAve> combo = (List<TipoAve>) request.getAttribute("combo");
													for (TipoAve ta : combo) {
										%>
										<option value="<%=ta.getIdTipoAve()%>"><%=ta.getNombre()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-danger">Guardar</button>
								<a type="button" class="btn btn-light">Volver</a>
							</div>
						</form>

						<%
							}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						%>



						<!--	-->

					</div>
				</div>
			</main>
		</div>
	</div>
	<script type="text/javascript" src="resources/js/vendor.js"></script>
	<script type="text/javascript" src="resources/js/bundle.js"></script>
</body>
</html>
