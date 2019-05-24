<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>运营管理</title>
	<meta name="viewport" content="initial-scale=1, maximum-scale=1">
	<link rel="shortcut icon" href="/favicon.ico">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
	<link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
	<link rel="stylesheet" href="//at.alicdn.com/t/font_1196941_k3akidoko6m.css">
	<style type="text/css">

	</style>
</head>

<body>
<div class="page-group">
	<div class="page page-current">
		<div class="content">
			<nav class="bar bar-tab">
				<a class="tab-item tab-link active" href="#stationTab">
					<span class="icon icon-font icon-charge"></span>
					<span class="tab-label">电站</span>
				</a>
				<a class="tab-item tab-link" href="#placeTab">
					<span class="icon icon-font icon-place"></span>
					<span class="tab-label">派单</span>
				</a>
				<a class="tab-item tab-link" href="#ongoingTab">
					<span class="icon icon-font icon-ongoing"></span>
					<span class="tab-label">进行中</span>
				</a>
				<a class="tab-item tab-link" href="#completeTab">
					<span class="icon icon-font icon-complete"></span>
					<span class="tab-label">完成</span>
				</a>
			</nav>

			<div class="content-block">
				<div class="tabs">
					<div id="stationTab" class="tab active">
						<div class="content">
							<div class="buttons-tab" id="stationTabButton">
								<a href="javascript:void(0);" class="active button" data-type="chargeData">电站</a>
								<a href="javascript:void(0);" class="button" data-type="stationFault">故障</a>
							</div>

							<div id="chargeData" >
								<div class="list-block" style="margin:5px 10px 0;">
									<ul>
										<li>
											<div class="item-content">
												<div class="item-inner">
													<div class="item-input">
														<input type="text" placeholder="选择电站" id='stationSelect' />
													</div>
												</div>
											</div>
										</li>
									</ul>
								</div>

								<div class="content-block-title" id="stationTitle" style="margin-top: 20px;">塘厦体院馆</div>
								<div id="chargeList">
									<div class="card">
										<div class="card-header">200085:直流  <span style="float: right;">通讯:正常 &nbsp;  运行:正常</span></div>
										<div class="card-content">
											<div class="card-content-inner">
												<div>枪号: 1 &nbsp; 状态: 充电 &nbsp; 电压: 390.9(V) &nbsp; 电流: 96.3(A)</div>
												<div>枪号: 2 &nbsp; 状态: 充电 &nbsp; 电压: 390.9(V) &nbsp; 电流: 96.3(A)</div>
											</div>
										</div>
									</div>
								</div>

								<div style="height: 80px;"></div>


							</div>

							<div id="stationFault" style="display: none;">
								暂无数据。
							</div>

						</div>
					</div>

					<div id="placeTab" class="tab">
						<div class="content">

							<div class="list-block" style="margin-top: 5px;">
								<ul>
									<li>
										<div class="item-content">
											<div class="item-inner">
												<div class="item-title label">电站</div>
												<div class="item-input">
													<input type="text" placeholder="选择电站" id='picker' />
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div id="ongoingTab" class="tab">
						<div class="content-block">
							<p>ongoingTab</p>
						</div>
					</div>
					<div id="completeTab" class="tab">
						<div class="content-block">
							<p>completeTab</p>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>
</div>

<script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type="text/javascript">
    var baseUrl = '<%= request.getContextPath() %>';

    $(function() {

        initStationSelect();

        $("#stationTabButton a").click(function(){
            var obj = $(this);
            var type = obj.data("type");
            var tabs = $("#stationTabButton a");

            $.each(tabs,function(index,item){
                $(item).attr("class","button");
            });
            obj.attr("class","active button");
            if(type == "chargeData"){
                $("#chargeData").css("display","");
                $("#stationFault").css("display","none");
            }else{
                $("#chargeData").css("display","none");
                $("#stationFault").css("display","");
            }
        });

        //默认加载塘厦体院馆工作数据
		loadStationWorkData(552);

		$.init();

    });

    function initStationSelect(){
        var dataArray = new Array();
        $.post(baseUrl + "/api/dingtalk/getStationKeyValue",function(response){
			if(response && response.data.length >0){
				$.each(response.data,function(index,item){
				    if(item.stationId != 1 && item.stationId != 305)
                    dataArray.push(item.stationName+"-"+item.stationId);
				});
			}

		},"json");
        $("#stationSelect").picker({
            toolbarTemplate: '<header class="bar bar-nav">\
						  <button class="button button-link pull-right close-picker">确定</button>\
						  <h1 class="title">选择电站</h1>\
						  </header>',
            cols: [{
                textAlign: 'center',
                values: dataArray
            }],
            formatValue:function(picker, value, displayValue){
                var val = value[0];
                var index = val.indexOf("-");
                if(index>0){
                    $("#stationSelect").attr("data-stationId",val.substring(index+1));
                    $("#stationTitle").text(val.substring(0,index));
                    return val.substring(0,index);
                }
                return val;
            },
            onClose: function(){
                var stationId = $("#stationSelect").attr("data-stationId");
                loadStationWorkData(stationId);
            }
        });
	}

    /**
	 * 加载电站工作数据
     * @param stationId
     */
    function loadStationWorkData(stationId){
        var chargeList = $("#chargeList");
        chargeList.html("");
		$.post(baseUrl + "/api/dingtalk/getStationWork",{stationId:stationId},function(response){
			if(response && response.chargerInfo.length > 0){
			    $("#stationTitle").text(response.chargerInfo[0].stationName);
			    var html = '';
			    $.each(response.chargerInfo,function(index,item){
                    html += '<div class="card">\n' +
                        '\t\t\t\t\t\t\t\t\t\t<div class="card-header" style="font-size:18px;">'+(subChargerSerialNum(item.chargerSerialNum))+' : '+ item.currentType +' <span style="float: right;">通讯 : '+commStatus(item.lost)+' &nbsp;  运行 : '+ faultStatus(item.emergencyStop)+'</span></div>\n' +
                        '\t\t\t\t\t\t\t\t\t\t<div class="card-content" style="font-size:15px;">\n' +
                        '\t\t\t\t\t\t\t\t\t\t\t<div class="card-content-inner">\n';


                    $.each(item.plugs,function (index1,item1) {
                        if(item1.workStatus == "CHARGING"){
                            html +=  '\t\t\t\t\t\t\t\t\t\t\t\t<div>枪号: '+ item1.plugNum +' &nbsp; 状态: '+ (plugWorkStatus(item1.workStatus)) +' &nbsp; 电流: '+item1.current+' &nbsp; 电压: '+item1.voltage+'</div>\n';
						}else if(item1.workStatus == "FAULT"){
                            html +=  '\t\t\t\t\t\t\t\t\t\t\t\t<div>枪号: '+ item1.plugNum +' &nbsp; 状态: '+ (plugWorkStatus(item1.workStatus)) +' &nbsp; 描述: '+item1.faultDescription+'</div>\n';
						}else{
                            html +=  '\t\t\t\t\t\t\t\t\t\t\t\t<div>枪号: '+ item1.plugNum +' &nbsp; 状态: '+ (plugWorkStatus(item1.workStatus))+'</div>' ;
						}

                    });

                    html+= '\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t\t\t\t</div>\n' +
                        '\t\t\t\t\t\t\t\t\t</div>';
				});

			    chargeList.html(html);
			}
		},"json");
    }

    /**
	 * 加载所有电站故障状态
     */
    function loadStationAllFaultData(){

    }

    function plugWorkStatus(workStatus){
		switch (workStatus) {
			case 'FAULT' :{
			    return '<i class="icon-font icon-fault" style="color:red;"></i>';
			}
            case 'FREE' :{
                return '<i class="icon-font icon-free" style="color:#0894ec;"></i>';
            }
            case 'CHARGING' :{
                return '<i class="icon-font icon-charging" style="color:#4CAF50;"></i>';
            }
            case 'PARK' :{
                return '<i class="icon-font icon-park" style="color:#0894ec;"></i>';
            }

        }
	}

    function subChargerSerialNum(chargerSerialNum){
		if(chargerSerialNum){
		    return chargerSerialNum.substring(chargerSerialNum.length - 6);
		}
		return '';
	}

    function commStatus(status){
		if(status){
            return '<i class="icon-font icon-comm" style="color:#d0d0d0;"></i>';
		}
        return '<i class="icon-font icon-comm" style="color:#4CAF50;"></i>';
	}

	function faultStatus(status){
        if(status){
            return '<i class="icon-font icon-fault" style="color:red;"></i>';
		}
        return '<i class="icon-font icon-work" style="color:#4CAF50;"></i>';
	}
</script>
</body>

</html>