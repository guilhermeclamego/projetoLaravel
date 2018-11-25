<%-- 
    Document   : relatorio
    Created on : 30/11/2016, 19:26:47
    Author     : guilherme
--%>

<%@page import="br.com.fatura.dao.JdbcDaoFactory"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%       
        //Conexao
        Connection conn = JdbcDaoFactory.abreConexao(); 
        //Endereço do relatorio, mesmo diretório das páginas jsp
        String relatorio = "/relatorios/RelatorioClientes.jasper";  
        //Criando arquivo
        File reportFile = new File(application.getRealPath(relatorio));  
        //Variavel auxiliar de hashmap
        Map parameters = new HashMap();
        //Pegando a quantidade de bytes
        byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (), parameters, conn);  
        //Formatando o conteúdo para arquivo pdf
        response.setContentType("application/pdf");
        //Passando o números de bytes
        response.setContentLength(bytes.length);  
        //Formatando a saída para o browser
        ServletOutputStream ouputStream = response.getOutputStream();  
        //Escrevendo conteúdo para o browser
        ouputStream.write(bytes, 0, bytes.length);  
        //Limpando memória
        ouputStream.flush();
        //Fechando a saída para browser
        ouputStream.close(); 
    %>
    </body>
</html>
