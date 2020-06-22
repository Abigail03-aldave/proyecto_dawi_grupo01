<jsp:include page="intranetValida.jsp" />
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<link rel="stylesheet" href="css/estilos.css"/>
<title>CIBERTEC</title>
</head>
<body>
<jsp:include page="intranetCabecera.jsp" />

 <div class="container">&nbsp;<br>&nbsp;<br>&nbsp;<br>
 <h1>Tipo de Reclamo</h1>
		 <div class="col-md-23" >  
			  <form id="idFormElimina" action="eliminaSede">
			  		<input type="hidden" id="id_elimina" name="id">
			  </form>	
				
		       <form accept-charset="UTF-8"  action="consultaSede" class="simple_form" id="defaultForm2"  method="post">
					<div class="row">
						<div class="col-md-3">	
							<div class="form-group">
							  	<label class="control-label" for="id_nombre_filtro">NOMBRE</label>
							  	<input class="form-control" id="id_nombre_filtro"  name="filtro" placeholder="Ingrese el texto" type="text" maxlength="30"/>
							</div>
						</div>
					</div>			
					<div class="row">
						<div class="col-md-3">
							<button type="submit" class="btn btn-primary" id="validateBtnw1" >FILTRA</button><br>&nbsp;<br>
						</div>
						<div class="col-md-3">
							<button type="button" data-toggle='modal' onclick="registrar();"  class='btn btn-success' id="validateBtnw2" >REGISTRA</button><br>&nbsp;<br>
						</div>
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table id="idTable" class="table table-striped table-bordered" >
										<thead>
											<tr>
												<th>ID</th>
												<th>Nombre</th>
												<th>Estado</th>
												<th>Actualiza </th>
											</tr>
										</thead>
										<tbody>
												   
												<c:forEach items="${sedes}" var="x">
													<tr>
														<td>${x.idSede}</td>
														<td>${x.nombre}</td>
														<td>${x.estado}</td>
														<td>
															<button type='button' data-toggle='modal' onclick="editar('${x.idSede}','${x.nombre}','${x.estado}');" class='btn btn-success' style='background-color:hsla(233, 100%, 100%, 0);'>
																<img src='images/edit.gif' width='auto' height='auto' />
															</button>
														</td>
													</tr>
												</c:forEach>
										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  
  	 <div class="modal fade" id="idModalRegistra" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Registro de Sede</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="idFormRegistra" accept-charset="UTF-8" action="registraSede" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de Sede</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                     <div class="form-group">
		                                     	<label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
												<div class="col-lg-5">
													<input class="form-control" id="id_reg_nombre"	name="sede.nombre" placeholder="Ingrese el texto" type="text" />
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button id="idBtnRegistra" type="submit" class="btn btn-primary">REGISTRA</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
		</div>
  
		 <div class="modal fade" id="idModalActualiza" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Actualiza Sede</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="idFormActualiza" accept-charset="UTF-8"  action="actualizaSede" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de Sede</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_act_ID">ID</label>
		                                        <div class="col-lg-5">
		                                           <input class="form-control" id="id_act_ID" readonly="readonly" name="sede.idSede" type="text" />
		                                        </div>
		                                     </div>
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_act_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_act_nombre" name="sede.nombre" placeholder="Ingrese el Nombre" type="text" />
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_act_estado">Estado</label>
		                                        <div class="col-lg-5">
													<select id="id_act_estado" name="sede.estado" class='form-control'>
							                                 <option value="" >[SELECCIONE]</option>
							                                 <option value="ACTIVO">ACTIVO</option>
							                                 <option value="INACTIVO">INACTIVO</option>
							                         </select>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button  id="idBtnActualiza"  type="submit" class="btn btn-primary">ACTUALIZA</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
		</div>

</div>

<script type="text/javascript">
function registrar(){	
	$('#idModalRegistra').modal("show");
}
function editar(id,nombre,estado){	
	$('input[id=id_act_ID]').val(id);
	$('input[id=id_act_nombre]').val(nombre);
	$('select[id=id_act_estado]').val(estado);
	$('#idModalActualiza').modal("show");
}
</script>

<script type="text/javascript">
		$(document).ready(function() {
			$('#idFormRegistra').bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					nombre : {
						selector : '#id_reg_nombre',
						validators : {
							notEmpty : {
								message : 'El nombre es un campo obligatorio'
							},
							stringLength : {
								message : 'El nombre es de 5 a 200 caracteres',
								min : 5,
								max : 200
							}
						}
					},

				}
			});

			// Validate the form manually
			$('#validateBtn').click(function() {
				$('#idFormRegistra').bootstrapValidator('validate');
			});
		});

		$(document).ready(function() {
			$('#idFormActualiza').bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					nombre : {
						selector : '#id_act_nombre',
						validators : {
							notEmpty : {
								message : 'El nombre es un campo obligatorio'
							},
							stringLength : {
								message : 'El nombre es de 5 a 200 caracteres',
								min : 5,
								max : 200
							}
						}
					},
					estado : {
						selector : '#id_act_estado',
						validators : {
							notEmpty : {
								message : 'El estado es un campo obligatorio'
							},
						}
					},
				}
			});

			// Validate the form manually
			$('#validateBtn').click(function() {
				$('#idFormActualiza').bootstrapValidator('validate');
			});
		});
</script>
</body>
</html> 