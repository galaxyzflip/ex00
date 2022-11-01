<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


       </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->





    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        
        $(".sidebar-nav")
        .attr("class", "sidebar-nav navbar-collapse collapse")
        .attr("aria-expanded", 'false')
        .attr("style", "height:1px");
    });
    </script>

</body>

</html>
	