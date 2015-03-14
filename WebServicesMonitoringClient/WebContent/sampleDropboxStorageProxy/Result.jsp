<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleDropboxStorageProxyid" scope="session" class="br.ufrn.services.server.storage.DropboxStorageProxy" />
<%
	if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleDropboxStorageProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleDropboxStorageProxyid.getEndpoint();
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
                sampleDropboxStorageProxyid.setEndpoint(endpoint_0idTemp);
        break;
        case 10:
                gotMethod = true;
                br.ufrn.services.server.storage.DropboxStorage getDropboxStorage10mtemp = sampleDropboxStorageProxyid.getDropboxStorage();
        if(getDropboxStorage10mtemp == null){
        %>
<%=getDropboxStorage10mtemp %>
<%
}else{
        if(getDropboxStorage10mtemp!= null){
        String tempreturnp11 = getDropboxStorage10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String accessToken_1id=  request.getParameter("accessToken16");
            java.lang.String accessToken_1idTemp = null;
        if(!accessToken_1id.equals("")){
         accessToken_1idTemp  = accessToken_1id;
        }
        String file_2id=  request.getParameter("file18");
            java.lang.String file_2idTemp = null;
        if(!file_2id.equals("")){
         file_2idTemp  = file_2id;
        }
        boolean getFile13mtemp = sampleDropboxStorageProxyid.getFile(accessToken_1idTemp,file_2idTemp);
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