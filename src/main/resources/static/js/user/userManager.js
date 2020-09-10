layui.use([ 'layer','jquery','table','laydate'], function() {
	var table = layui.table,laydate = layui.laydate,
		layer =layui.layer,
		$ = layui.jquery;
	laydate.render({
		elem: '#bgtime' // 指定元素
		,type: 'datetime'
	});

	laydate.render({
		elem: '#edtime' // 指定元素
		,type: 'datetime'
	});

	//数据表格,列表展示  其中templet 为自定义内容显示
	var grid = table.render({
		id : 'myTable'
		,elem: '#myTable'
		,url: 'findList' //数据接口
		,height: 'full-140'
		,limit:10//每页默认数
		,limits:[10,20,30,40,50]
		,cols: [[ //表头
			{type:'radio'}
			,{type: 'numbers', title: '序号'}
			,{field:'userName', title: '用户名',align: 'center'}
			,{field:'realName', title: '真实姓名',align: 'center'}
			,{field:'sex', title: '性别',align: 'center',templet: function(val){
				var html;
				if(val.sex == 0){
					html = '女';
				}else{
					html = '男';
				}
					return html;
				}
			}
			,{field:'email', title: '邮箱',align: 'center'}
			,{field:'phone', title: '手机号',align: 'center'}
			,{field:'userStatus', title: '用户状态',align: 'center',templet: function (val) {
					var html;
					if(val.userStatus == 0){
						html = '可用';
					}else{
						html = '禁用';
					}
					return html;
				}
			}
			,{field:'createDate', title: '创建时间',align: 'center'}
			,{field:'note', title: '备注',align: 'center'}
		]]
		,page: true //开启分页
		,toolbar: '#myToolbar'
		,defaultToolbar:[]
	});

	//监听事件
	table.on('toolbar(myTable)', function(obj){
		var urls,title;
		var width = "670px";
		var height = "520px";
		var pstUrl = "save";
		if(obj.event == 'add'){
			title = "增加";
			urls = "findById";
		}else {
			var checkStatus = table.checkStatus(obj.config.id), data = checkStatus.data;
			if(data.length != 1){
				layer.msg("请选择一条要操作的数据！", {
					icon : 5
				});
				return;
			}
			if(obj.event == 'edit'){
				title = '编辑';
				urls = "findById?modelId=" +  data[0].id;
			} else if(obj.event == 'del'){
				urls = 'deleteById?modelId=' +  data[0].id;
				deleteGridRow(urls,grid,$);
				return;
			} else{
				return;
			}
		}
		//此处注意宽高需带单位
		openWin(title,urls,pstUrl,width,height,grid);
	});


	//查询
	$("#search").click(function() {
		var obj = {};
		obj.keyName = $("#keyName").val();
		obj.bgtime = $("#bgtime").val();
		obj.edtime = $("#edtime").val();
		doSearch(grid,obj);
	});
});