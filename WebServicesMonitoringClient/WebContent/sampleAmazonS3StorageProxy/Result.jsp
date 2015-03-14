<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAmazonS3StorageProxyid" scope="session" class="br.ufrn.services.server.storage.AmazonS3StorageProxy" />
<%
	if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAmazonS3StorageProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
	String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAmazonS3StorageProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp%>
<%
	}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
%>
        <%=tempResultreturnp3%>
        <%
        	}
        break;
        case 5:
                gotMethod = true;
                String endpoint_0id=  request.getParameter("endpoint8");
                    java.lang.String endpoint_0idTemp = null;
                if(!endpoint_0id.equals("")){
                 endpoint_0idTemp  = endpoint_0id;
                }
                sampleAmazonS3StorageProxyid.setEndpoint(endpoint_0idTemp);
        break;
        case 10:
                gotMethod = true;
                br.ufrn.services.server.storage.AmazonS3Storage getAmazonS3Storage10mtemp = sampleAmazonS3StorageProxyid.getAmazonS3Storage();
        if(getAmazonS3Storage10mtemp == null){
        %>
<%=getAmazonS3Storage10mtemp %>
<%
}else{
        if(getAmazonS3Storage10mtemp!= null){
        String tempreturnp11 = getAmazonS3Storage10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String accessKey_1id=  request.getParameter("accessKey16");
            java.lang.String accessKey_1idTemp = null;
        if(!accessKey_1id.equals("")){
         accessKey_1idTemp  = accessKey_1id;
        }
        String secretKey_2id=  request.getParameter("secretKey18");
            java.lang.String secretKey_2idTemp = null;
        if(!secretKey_2id.equals("")){
         secretKey_2idTemp  = secretKey_2id;
        }
        String bucketName_3id=  request.getParameter("bucketName20");
            java.lang.String bucketName_3idTemp = null;
        if(!bucketName_3id.equals("")){
         bucketName_3idTemp  = bucketName_3id;
        }
        String fileName_4id=  request.getParameter("fileName22");
            java.lang.String fileName_4idTemp = null;
        if(!fileName_4id.equals("")){
         fileName_4idTemp  = fileName_4id;
        }
        boolean getFile13mtemp = sampleAmazonS3StorageProxyid.getFile(accessKey_1idTemp,secretKey_2idTemp,bucketName_3idTemp,fileName_4idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getFile13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>