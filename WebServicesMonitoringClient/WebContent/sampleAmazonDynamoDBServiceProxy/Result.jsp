<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAmazonDynamoDBServiceProxyid" scope="session" class="br.ufrn.services.server.log.AmazonDynamoDBServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAmazonDynamoDBServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleAmazonDynamoDBServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
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
        sampleAmazonDynamoDBServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        br.ufrn.services.server.log.AmazonDynamoDBService getAmazonDynamoDBService10mtemp = sampleAmazonDynamoDBServiceProxyid.getAmazonDynamoDBService();
if(getAmazonDynamoDBService10mtemp == null){
%>
<%=getAmazonDynamoDBService10mtemp %>
<%
}else{
        if(getAmazonDynamoDBService10mtemp!= null){
        String tempreturnp11 = getAmazonDynamoDBService10mtemp.toString();
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
        String keyItem_3id=  request.getParameter("keyItem20");
            java.lang.String keyItem_3idTemp = null;
        if(!keyItem_3id.equals("")){
         keyItem_3idTemp  = keyItem_3id;
        }
        java.lang.String getItem13mtemp = sampleAmazonDynamoDBServiceProxyid.getItem(accessKey_1idTemp,secretKey_2idTemp,keyItem_3idTemp);
if(getItem13mtemp == null){
%>
<%=getItem13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getItem13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
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