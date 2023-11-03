<html>
    <body>
        <h1>
            Welcome to Spring Boot MVC!
            <%=new java.util.Date()%>
            <%
                response.addHeader("Refresh", "5;https://www.google.com/");
            %>
        </h1>
        Please wait 5 seconds, do not press back button or refresh!
    </body>
</html>