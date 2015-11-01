<%@ include file="common.jspf" %>
<html>
<head>
	<title>Elevator Simulator</title>
	<%@ include file="header.jspf" %>
	<script type="text/javascript" src='<spring:url value="/resources/js/holm-simulator-populator-jquery-ui-plugin-1.0.js" htmlEscape="true" />'></script>
</head>
<body>
 <div class="container"> 
 
 <fieldset class="simulator">
    <legend id="msg">Elevators</legend>
    
    <c:forEach items="${elevators}" var="elevator">
	    <div class='row'>
         <div class='col-md-8'>    
           <div class="form-group">
              <label>${elevator.address}</label>
              <div style="background-color: rgb(241, 241, 241);">
               <i id="${elevator.id}-door" class="glyph-icon flaticon-building72"></i>
               <i id="${elevator.id}-direction" class="fa fa-long-arrow-up"></i>
			    &nbsp &nbsp<i id="${elevator.id}-floor" class="floor" ></i>&nbsp&nbsp&nbsp&nbsp
			   <i id="${elevator.id}-weight" class="flaticon-weight11" ></i>&nbsp&nbsp&nbsp&nbsp
			    <i id="${elevator.id}-date" class="fa fa-clock-o"></i>
			   
			  </div>  
           </div>
         </div>
     </div>
	    
	</c:forEach>
   
     
    
  </fieldset>
	
 </div> <!-- container -->
 
 
 <script type="text/javascript">
 globalAjaxURL = '${servletContext}';
$(document).ready(function(){
	$(".fa").removeClass();
	$.get(globalAjaxURL + '/getData',
	  function(msg) {
		console.log(msg);
	   $("#msg").text(msg);
	  }		
	);
	
	$( ".simulator" ).simulatorUI();
});

</script>   
 
	
</body>
</html>
