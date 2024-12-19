String[] domainExclude = {
	"firefoxchina", "mozilla",
	"ibytedapm.com", "byteimg.com", "bytegoofy.com", "googleapis", 
	"feelgood.cn", "bytescm.com", "bytetos.com", "yhgfb-cn-static.com", 
	"bydauto", "ecombdstatic", "feishucdn", "snssdk", "zijieapi",
    "map.qq.com","map.gtimg.com","restapi.amap.com", 
    "qpic.cn","tim.qq.com","im.qcloud.com","qlogo.cn"
    
};

String[] pathExclude = {"WebSocket", ".js", ".css", ".png", ".woff", "woff2"};

String[] methodExclude = {"OPTIONS", "HEAD"};

MimeType[] mimetypeExclude = {
    MimeType.APPLICATION_UNKNOWN, MimeType.UNRECOGNIZED,
    MimeType.FONT_WOFF2, MimeType.FONT_WOFF, 
    MimeType.VIDEO, MimeType.SOUND,  
    MimeType.IMAGE_TIFF, MimeType.IMAGE_BMP,  MimeType.IMAGE_PNG, MimeType.IMAGE_GIF, MimeType.IMAGE_JPEG, MimeType.IMAGE_UNKNOWN, 
    MimeType.CSS
    };

String[] bodyExclude = {""};

String HostValue = requestResponse.request().headerValue("Host");
String host = requestResponse.request().httpService().host();
String path = requestResponse.request().path();
String method = requestResponse.request().method();
String body = requestResponse.request().body().toString();
var mimeType = requestResponse.mimeType();
return Arrays.stream(domainExclude).noneMatch(it -> host.contains(it))
	   && Arrays.stream(domainExclude).noneMatch(it -> HostValue.contains(it))
	   && Arrays.stream(pathExclude).noneMatch(it -> path.contains(it))
	   && Arrays.stream(methodExclude).noneMatch(it -> method.contains(it))
	   && Arrays.stream(mimetypeExclude).noneMatch(it -> mimeType == it)
       && Arrays.stream(bodyExclude).filter(it -> it != null && it.length() != 0).noneMatch(it -> body.contains(it));
