/* �Զ���Ӧ����߶�  */
function resizeWindows(id){
	var obj = $(id);
	var mainHeight = obj.height();
	//-parseInt($("#"+id).css("margin-top"))*2
	//��ȡ����ı߿�߶�
	var boderWidth = isNaN(parseInt(obj.css("border-width")))? 0:parseInt(obj.css("border-width"));
	//��ȡ~����߾�
	var marginTop = isNaN(parseInt(obj.css("margin-top")))? 0:parseInt(obj.css("margin-top"));
	//��ȡ~����߾�
	var marginBottom =isNaN(parseInt(obj.css("margin-bottom")))? 0:parseInt(obj.css("margin-bottom"));
	var lastHeight = $(window).height()-boderWidth-marginTop-marginBottom;
	if(mainHeight>=lastHeight){
		lastHeight = mainHeight;
	}
	obj.height(lastHeight);
}