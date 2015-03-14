<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleGoogleCloudDatabaseServiceProxyid" scope="session" class="br.ufrn.services.server.databases.GoogleCloudDatabaseServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleGoogleCloudDatabaseServiceProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleGoogleCloudDatabaseServiceProxyid.getEndpoint();
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
        sampleGoogleCloudDatabaseServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        br.ufrn.services.server.databases.GoogleCloudDatabaseService getGoogleCloudDatabaseService10mtemp = sampleGoogleCloudDatabaseServiceProxyid.getGoogleCloudDatabaseService();
if(getGoogleCloudDatabaseService10mtemp == null){
%>
<%=getGoogleCloudDatabaseService10mtemp %>
<%
}else{
        if(getGoogleCloudDatabaseService10mtemp!= null){
        String tempreturnp11 = getGoogleCloudDatabaseService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String host_1id=  request.getParameter("host16");
            java.lang.String host_1idTemp = null;
        if(!host_1id.equals("")){
         host_1idTemp  = host_1id;
        }
        String user_2id=  request.getParameter("user18");
            java.lang.String user_2idTemp = null;
        if(!user_2id.equals("")){
         user_2idTemp  = user_2id;
        }
        String pwd_3id=  request.getParameter("pwd20");
            java.lang.String pwd_3idTemp = null;
        if(!pwd_3id.equals("")){
         pwd_3idTemp  = pwd_3id;
        }
        double connectDatabaseGoogleCloud13mtemp = sampleGoogleCloudDatabaseServiceProxyid.connectDatabaseGoogleCloud(host_1idTemp,user_2idTemp,pwd_3idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(connectDatabaseGoogleCloud13mtemp));
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