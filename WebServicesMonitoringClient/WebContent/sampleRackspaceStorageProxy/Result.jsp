<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleRackspaceStorageProxyid" scope="session" class="br.ufrn.services.server.storage.RackspaceStorageProxy" />
<%
	if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleRackspaceStorageProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleRackspaceStorageProxyid.getEndpoint();
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
                sampleRackspaceStorageProxyid.setEndpoint(endpoint_0idTemp);
        break;
        case 10:
                gotMethod = true;
                br.ufrn.services.server.storage.RackspaceStorage getRackspaceStorage10mtemp = sampleRackspaceStorageProxyid.getRackspaceStorage();
        if(getRackspaceStorage10mtemp == null){
        %>
<%=getRackspaceStorage10mtemp %>
<%
}else{
        if(getRackspaceStorage10mtemp!= null){
        String tempreturnp11 = getRackspaceStorage10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String user_1id=  request.getParameter("user16");
            java.lang.String user_1idTemp = null;
        if(!user_1id.equals("")){
         user_1idTemp  = user_1id;
        }
        String apiKey_2id=  request.getParameter("apiKey18");
            java.lang.String apiKey_2idTemp = null;
        if(!apiKey_2id.equals("")){
         apiKey_2idTemp  = apiKey_2id;
        }
        String region_3id=  request.getParameter("region20");
            java.lang.String region_3idTemp = null;
        if(!region_3id.equals("")){
         region_3idTemp  = region_3id;
        }
        String container_4id=  request.getParameter("container22");
            java.lang.String container_4idTemp = null;
        if(!container_4id.equals("")){
         container_4idTemp  = container_4id;
        }
        String file_5id=  request.getParameter("file24");
            java.lang.String file_5idTemp = null;
        if(!file_5id.equals("")){
         file_5idTemp  = file_5id;
        }
        boolean getFile13mtemp = sampleRackspaceStorageProxyid.getFile(user_1idTemp,apiKey_2idTemp,region_3idTemp,container_4idTemp,file_5idTemp);
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