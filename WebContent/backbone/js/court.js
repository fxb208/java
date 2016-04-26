
(function(){
	
// var jsonValue = null;
	
	/**
	 * 跳转地址
	 */
	Pay.skipUrl = {
		'home':'/szlhfy/index',// 首页
		'searchJudge':'/szlhfy/searchJudge',// 查询法官
		'judgeDetail':'/szlhfy/judgeDetail',// 法官详情
		'navigation':'/szlhfy/navigation',// 交通导航
		'courtReadA':'/szlhfy/courtReadA',// 审判流程公开
		'courtPublicQueryA':'/szlhfy/courtPublicQueryA',// 审判流程公开>>>社会公众查询
		'courtQueryContentB':'/szlhfy/courtQueryContentB',// 审判流程公开>>>社会公众查询>>>查询结果
		'courtGuide':'/szlhfy/courtGuide',// 审判流程公开>>>当事人查询>>>案件列表
		'courtQueryNoticeA':'/szlhfy/courtQueryNoticeA',// 审判流程公开>>>当事人查询
		'courtPartyQueryA':'/szlhfy/courtPartyQueryA',// 审判流程公开>>>当事人查询>>>查询页面
		'courtQueryContentC':'/szlhfy/courtQueryContentC',// 审判流程公开>>>当事人查询>>>查询页面>>>查询结果
		'courtParty':'/szlhfy/courtPartyQueryAIsOk',// 审判流程公开>>>当事人查询>>>查询页面>>>跳转页面控制
		'courtRead':'/szlhfy/courtRead',// 执行信息公开
//		'courtPublicQuery':'/szlhfy/courtPublicQuery',// 执行信息公开>>>社会公众查询
//		'courtQueryContent':'/szlhfy/courtQueryContent',// 执行信息公开>>>社会公众查询>>>查询结果
		'courtQueryNotice':'/szlhfy/courtQueryNotice',// 执行信息公开>>当事人查询
		'courtPartyQuery':'/szlhfy/courtPartyQuery',// 当事人查询>>>查询页面
		'courtguideList':'/szlhfy/courtguideList',// 当事人查询>>>查询页面>>>案件列表
		'courtQueryContentA':'/szlhfy/courtQueryContentA',// 当事人查询>>>查询页面>>>查询结果
		'courtPartyA':'/szlhfy/courtPartyQueryAIsOkA',// >当事人查询>>>查询页面>>>跳转页面控制
		'courtJudicial':'/szlhfy/courtJudicial',// 审判文书公开
		'documentsPage':'/szlhfy/documentsPage'// 文书页面
			
		
		
		
	};
		
	/**
	 * 跳转地址控制
	 */
	var skipRouter = Backbone.Router.extend({
		routes:{
			'home':'home',// 首页
			'searchJudge':'searchJudge',// 查询法官
			'judgeDetail':'judgeDetail',// 法官详情
			'navigation':'navigation',// 交通导航
			'courtReadA':'courtReadA',// 审判流程公开
			'courtPublicQueryA':'courtPublicQueryA',// 审判流程公开>>>社会公众查询
			'courtQueryContentB':'courtQueryContentB',// 审判流程公开>>>社会公众查询>>>查询结果
			'courtQueryNoticeA':'courtQueryNoticeA',// 审判流程公开>>>当事人查询
			'courtPartyQueryA':'courtPartyQueryA',// 审判流程公开>>>当事人查询>>>查询页面
			'courtQueryContentC':'courtQueryContentC',// 审判流程公开>>>当事人查询>>>查询页面>>>查询结果
			'courtParty':'courtParty',// 审判流程公开>>>当事人查询>>>查询页面>>>跳转页面控制
			'courtGuide':'courtGuide',// 审判流程公开>>>当事人查询>>>查询页面>>>案件列表
			'courtRead':'courtRead',// 执行信息公开
//			'courtPublicQuery':'courtPublicQuery',// 执行信息公开>>>社会公众查询
//			'courtQueryContent':'courtQueryContent',// 执行信息公开>>>社会公众查询>>>查询结果
			'courtQueryNotice':'courtQueryNotice',// 执行信息公开>>当事人查询
			'courtPartyQuery':'courtPartyQuery',// 当事人查询>>>查询页面
			'courtguideList':'courtguideList',// 当事人查询>>>查询页面>>>案件列表
			'courtQueryContentA':'courtQueryContentA',// 当事人查询>>>查询页面>>>查询结果
			'courtPartyA':'courtPartyA',// 当事人查询>>>查询页面>>>跳转页面控制
			'courtJudicial':'courtJudicial',// 审判文书公开
			'documentsPage':'documentsPage'// 文书页面
			
		},
		initialize:function(el,current){
        	this.$el = $(el);
        	this._current = current;
        },
        hidePages: function(){
            if(this._current){
            	this._current.$el.hide();
            }
            this.$el.children().remove();
        },
        loadPage:function(url,params,success){
        	this.hidePages();
        	var self = this;
        	Loding.show();
        	$.get(url,params,function(rest){
        		Loding.hide();
        		self.$el.html(rest);
        		self.current = success.call(self,rest);
        	});
        },
        analyzeParam:function(args){// 解析请求地址参数
        	var param = {};
        	if(args){
        	    args = args.split('&');
	        	for(var i=0; i<args.length; i++){
	        		var tmp = args[i].split('=');
	        		if(tmp && tmp.length==2){
	        			if($.trim(tmp[0]))
	        				param[tmp[0]] = tmp[1];
	        		}
	        	}
        	}
        	return param;
        },
        getCurFun:function(){// 获取当前请求功能
        	var fragment = Backbone.history.fragment;
        		if(fragment.indexOf('?') != -1){
        			fragment = fragment.substring(0,fragment.indexOf('?'));
        		}
        	return fragment;
        },
        home:function(args){
        	if(this.$el)
    			this.$el.children().remove();
        	if(this._current){
        		location.href = Pay.skipUrl['home'];
        	}
        },
        searchJudge:function(args){// 联系法官
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new SearchJudge(param);
        	});
        },
        courtParty:function(args){// 审判流程公开>>>当事人查询>>>查询页面>>>跳转页面控制
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		var pageId = this.$el.find("div").eq(0).attr("id");
        		if(pageId == 'court_query_content_02'){
        			new courtQueryContentC(param);
        		}else if(pageId == 'court_guide'){
        			new courtGuide(param);
        		}
        	});
        },
        courtPartyA:function(args){// 当事人查询>>>查询页面>>>跳转页面控制
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		var pageId = this.$el.find("div").eq(0).attr("id");
        		if(pageId == 'court_query_content_03'){
        			new courtQueryContentA(param);
        		}else if(pageId == 'court_guide_list'){
        			new courtguideList(param);
        		}
        	});
        },
        judgeDetail:function(args){// 联系法官
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new JudgeDetail(param);
        	});
        },
        navigation:function(args){// 交通导航
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new Navigation(param);
        	});
        },
        courtReadA:function(args){// 审判流程公开
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtReadA(param);
        	});
        },
        courtPublicQueryA:function(args){// 审判流程公开>>>社会公众查询
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new CourtPublicQueryA(param);
        	});
        },
        courtQueryContentB:function(args){// 审判流程公开>>>社会公众查询>>>查询结果
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtQueryContentB(param);
        	});
        },
        courtGuide:function(args){// 审判流程公开>>>社会公众查询>>>查询结果>>>案件列表
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtGuide(param);
        	});
        },
        courtQueryNoticeA:function(args){// 审判流程公开>>>当事人查询
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtQueryNoticeA(param);
        	});
        },
        courtPartyQueryA:function(args){// 审判流程公开>>>当事人查询>>>查询页面
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtPartyQueryA(param);
        	});
        },
        courtQueryContentC:function(args){// 审判流程公开>>>当事人查询>>>查询页面>>>查询结果
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtQueryContentC(param);
        	});
        },
//        courtPublicQuery:function(args){// 执行信息公开>>>社会公众查询
//        	var param = this.analyzeParam(args);
//        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
//        		new CourtPublicQuery(param);
//        	});
//        },
        courtRead:function(args){// 执行信息公开
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new CourtRead(param);
        	});
        },
//        courtQueryContent:function(args){// 执行信息公开>>>社会公众查询>>>查询结果
//        	var param = this.analyzeParam(args);
//        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
//        		new courtQueryContent(param);
//        	});
//        },
        courtQueryNotice:function(args){// 执行信息公开>>>当事人查询
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtQueryNotice(param);
        	});
        },
        courtPartyQuery:function(args){// 当事人查询>>>查询页面
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtPartyQuery(param);
        	});
        },
        courtguideList:function(args){// 当事人查询>>>查询页面>>>查询列表
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtguideList(param);
        	});
        },
        courtQueryContentA:function(args){// 当事人查询>>>查询页面>>>查询结果
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtQueryContentA(param);
        	});
        },
        courtJudicial:function(args){// 审判文书公开
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new courtJudicial(param);
        	});
        },
        documentsPage:function(args){// 文书页面
        	var param = this.analyzeParam(args);
        	this.loadPage(Pay.skipUrl[this.getCurFun()], param, function(){
        		new documentsPage(param);
        	});
        }
	});
	
	/**
	 * 法官详情
	 */
	var JudgeDetail=Backbone.View.extend({
		el:'#court_judge_info',
		events:{
			'click .footer_back':'onClickBack',// 退回
		},
		onClickBack:function(){// 回到上级
			var self = this;
			var name=self.param.name;
			var department=self.param.department;
			Backbone.history.navigate('searchJudge?'+'name='+name+'&department='+department,true);
		},
		initialize:function(param){
			var self = this;
			$('body').removeClass('index_bg');
			this.param = param;
		}
	});
	
	
	
	
	/**
	 * 联系法官
	 */
	var SearchJudge=Backbone.View.extend({
		el:'#court_call_judge',
		events:{
			'click .footer_back':'onClickBack',// 退回
			'click .button':'doSearch',// 搜索
			'click .info_left':'onClickDetail'
		},
		onClickBack:function(){// 回到上级
			var self = this;
			Backbone.history.navigate('home',true);
		},
		doSearch:function(){
			var self = this;
			var name=self.$('input[name=name]').val();
			var department=$('#department').val();
			name=encodeURI(name);
			department=encodeURI(department);
			Backbone.history.navigate('searchJudge?name='+name+'&'+'department='+department,true);
		},
		initialize:function(param){
			var self = this;
			$('body').removeClass('index_bg');
			this.param = param;
		},
		onClickDetail:function(e){// 查看法官详情
			var self = this, curTarget = self.$(e.currentTarget);
			var judgeId=curTarget.attr('judgeId');
			var name=self.param.name;
			var department=self.param.department;
			Backbone.history.navigate('judgeDetail?judgeId='+judgeId+'&name='+name+'&department='+department,true);
		}
	});
	
	// 交通导航
	var Navigation = Backbone.View.extend({
		el:'#court_go_map',
		mel:'shops-detail-map',
		BMap:$.extend(window.BMap || {}, {
			Convertor : {
				translate : $.translate
			}
		}),
		map:undefined,
		pointer:undefined,
		events:{
			'click #go-here':'onClickGoHere',// 去这里
			'click #down':'onClickDown'
		},
		initialize:function(param){
			var self = this;
			self._cfg = param;
			$('body').removeClass('index_bg');
			self.pointer = $('#'+self.mel).attr('pointer');
			self.pointer = self.pointer.split(',');
			// 目标位置
			self.drawMap({longitude:self.pointer[0],latitude:self.pointer[1]});
		},
		drawMap:function(position){
			var lng = 0, lat = 0, self = this;
			// 获取到当前位置经纬度 本例中是chrome浏览器取到的是google地图中的经纬度
			if(position.coords){
				lng = position.coords.longitude;
		        lat = position.coords.latitude;
			}else{
				lng = position.longitude;
				lat = position.latitude;
			}
			
			self.map = self.map == undefined ? new self.BMap.Map(self.mel) : self.map;
	        var ggPoint = new self.BMap.Point(lng, lat);
	        self.BMap.Convertor.translate(ggPoint, 2, function(point){
	            var marker = new self.BMap.Marker(point);
	            self.map.addOverlay(marker);
	            self.map.centerAndZoom(point, 15);
	        });
		},
		onClickGoHere:function(){
			var lng = 0, lat = 0 , self = this;
			if (window.navigator.geolocation) {
	           var options = {
	               enableHighAccuracy: true,
	           };
	           function seccess(position){
	        	   lng = position.coords.longitude;
	        	   lat = position.coords.latitude;
	               
	        	   var startPoint = new self.BMap.Point(lng, lat);
	        	   var endPoint = new self.BMap.Point(self.pointer[0],self.pointer[1]);
	        	   self.map.centerAndZoom(endPoint, 15);
	        	   var walking = new self.BMap.TransitRoute(self.map, {renderOptions:{map: self.map,panel: "top-result"}});
	        	   walking.search(startPoint, endPoint);
	           }
	           window.navigator.geolocation.getCurrentPosition(seccess, function(){}, options);
			}
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	
	// 执行信息公开
	var CourtRead = Backbone.View.extend({
		el:'#court_read4',
		events:{
			'click #courtPublicQuery':'onClickCourtPublicQuery',// 社会公众查询
			'click #courtQueryNotice':'onClickcourtQueryNotice',// 当事人查询
			'click #down':'onClickDown'
		},
		initialize:function(param){
			var self = this;
			$('body').removeClass('index_bg');
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		},
//		onClickCourtPublicQuery:function(e){
//			Backbone.history.navigate('courtPublicQuery',true);
//		},
		onClickcourtQueryNotice:function(e){
			Backbone.history.navigate('courtQueryNotice',true);
		}
	});
	// 审判流程公开
	var courtReadA = Backbone.View.extend({
		el:'#court_readA',
		events:{
			'click #courtPublicQueryA':'onClickCourtPublicQueryA',// 社会公众查询
			'click #courtQueryNoticeA':'onClickcourtQueryNoticeA',// 审判流程公开>>>当事人查询
			'click #down':'onClickDown'
		},
		initialize:function(param){
			var self = this;
			$('body').removeClass('index_bg');
		},
		onClickCourtPublicQueryA:function(){
			Backbone.history.navigate('courtPublicQueryA',true);
		},
		onClickcourtQueryNoticeA:function(){
			Backbone.history.navigate('courtQueryNoticeA',true);
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	// 审判流程公开>>>社会公众查询
	var CourtPublicQueryA = Backbone.View.extend({
		el:'#court_public_queryA',
		events:{
			'click #courtQueryContentB':'onClickcourtQueryContentB',// 查询结果
			'click #down':'onClickDown',
			'click #back':'onClickBack'
		},
		initialize:function(param){
			$('body').removeClass('index_bg');
			this.flag=0;
			$(document).ready(function(){
				var hasSelectBox=$(".select_val").length;
							if(hasSelectBox){
								$(".select_val").on("click",function(){
									$(".select_val").removeClass("on");
									$(this).addClass("on");
									$(".select_option").hide();
									$(".select_option_son").hide();
									$(this).parent().find(".select_option").toggle();
									$(".select_val_out").click(function(){
										$(".select_option_son").hide();
										$(this).parent().find(".select_option_son").show();
									});	
								});
								$(".select_option_son").find("li").on("click",function(){
									var optionVal=$(this).html();
									$(this).parent().parent().parent().parent().find(".select_val").html(optionVal).removeClass("on");
									$(this).parent().hide();
									$(".select_option").hide();
								});
							}
			})
			var self = this;
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		},
		onClickBack:function(){	
			Backbone.history.navigate('courtReadA',true);
		},
		onClickcourtQueryContentB:function(e){
			var self = this;
			var caseNoyear = "("+self.$("#caseNoyear").find("option:selected").text()+")",
				caseNotapye= "深罗法"+self.$('.select_val').text()+"字",
				caseNos = "第"+self.$('#caseNos').val()+"号",
				caseNo = caseNoyear+caseNotapye+caseNos;
			if(caseNoyear=='请选择案件年份'){
				Swiftpass.Alert('系统提示','请选择案件年份！');
				return;
			}else{
			if(caseNotapye=='深罗法请选择案件字号字'){
				Swiftpass.Alert('系统提示','请选择案件字号！');
				return;
			}else{
			if(caseNos == '第号'){
				Swiftpass.Alert('系统提示','请输入案号！');
				return;
			}else{
				if($(".CaseNo").text() == ""){
					$(".CaseNo").text("您要查询的是："+caseNo);
					self.$("#courtQueryContentB").text("确 定");
				}else{
					if(self.flag==0){
						self.flag=1;
						$.postJSON('/szlhfy/courtQueryContentBIsOk',{caseNo:caseNo},function(rest){
							if(rest.status){
								Backbone.history.navigate('courtQueryContentB?caseNo='+caseNo,true);
							}else{
								Swiftpass.Alert('系统提示',rest.message);
								$(".CaseNo").text("");
								self.$("#courtQueryContentB").text("查 询");
								self.flag=0;
							}				
						});
					}
				}
		   }
		  }
		 }
		}
	});
	
	// 审判流程公开>>>社会公众查询>>>查询结果
	var courtQueryContentB = Backbone.View.extend({
		el:'#court_query_contentA',
		events:{
			'click #go-here':'onClickGoHere',// 去这里
			'click #down':'onClickDown',
			'click #back':'onClickBack'// 返回
		},
		initialize:function(param){
			var self = this;
			$('body').removeClass('index_bg');
		},
		onClickBack:function(){
			Backbone.history.navigate('courtPublicQueryA',true);
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	
	// 审判流程公开>>>当事人查询>>>案件列表
	var courtGuide = Backbone.View.extend({
		el:'#court_guide',
		events:{
			'click #courtQueryContentC':'onClickcourtQueryContentC',// 去这里
			'click #down':'onClickDown',
			'click #back':'onClickBack'// 返回
		},
		onClickcourtQueryContentC:function(e){
			var id = $("#courtQueryContentC").attr("caseid");
			var cardType = $("#selectTab1").attr("cardType");
			var idcard = $("#selectTab1").attr("idcard");
			var code = $("#selectTab1").attr("code");
			var infoTotal = $("#selectTab1").attr("infoTotal");
			Backbone.history.navigate('courtQueryContentC?id='+id+'&idcard='+idcard+'&code='+code+'&cardType='+cardType+'&infoTotal='+infoTotal,true);
		},
		onClickBack:function(){
			  $.postJSON('/szlhfy/LogoutSecd',{},function(rest){
			  if(rest.status){
				Backbone.history.navigate('courtPartyQueryA',true);
			  	}else{
					Swiftpass.Alert('系统提示',rest.message);
				}
			});
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	
	// 审判流程公开>>>当事人查询
	var courtQueryNoticeA = Backbone.View.extend({
		el:'#court_query_noticeA',
		events:{
			'click #go-here':'onClickGoHere',// 去这里
			'click #back':'onClickBack',// 返回
			'click #checkbox':'onClickcheckbox',// 复选框样式
			'click #Next':'onClickNext',// 下一步
			'click #down':'onClickDown'
		},
		initialize:function(param){
			var self = this;
			$('body').removeClass('index_bg');
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		},
		onClickcheckbox:function(){
			if($(".checkbox_sel").hasClass("on")){
				$(".checkbox_sel").removeClass("on");
				$(".button").addClass("no_next");
			}else{
				$(".checkbox_sel").addClass("on");
				$(".button").removeClass("no_next");
			}
		},
		onClickBack:function(){
			Backbone.history.navigate('courtReadA',true);
		},
		onClickNext:function(){
			if($(".checkbox_sel").hasClass("on")){
				Backbone.history.navigate('courtPartyQueryA',true);
			}else{
				Backbone.history.navigate('courtQueryNoticeA',true);
			}
		}
	});
	
	// 审判流程公开>>>当事人查询>>>查询页面
	var courtPartyQueryA = Backbone.View.extend({
		el:'#court_party_queryA',
		interval:undefined,
		events:{
			'click #courtQueryContentC':'onClickcourtQueryContentC',// 查询结果
			'click #down':'onClickDown',
			'click #password_button':'onClickpassword_button',// 收取短信密码
			'click #back':'onClickBack'
		},
		initialize:function(param){
			this.flag=0;
			var self = this;
			$('body').removeClass('index_bg');
			this.prama = param;
		},
		onClickcourtQueryContentC:function(rest){
			var self=this;
			var idcard = $('#idcard').val(),code =self.$('#code').val(),cardType=self.$('select[name=cardType]').val();
			if(code == ''){
				Swiftpass.Alert('系统提示','请输入密码！');
				return;
			}else{
			if(self.flag==0){
				self.flag=1;
				// 1:ajax 校验
				$.postJSON('/szlhfy/courtPartyAjaxs',{idcard:idcard,code:code,cardType:cardType},function(rest){
					if(rest.status){
						Backbone.history.navigate('courtParty?idcard='+idcard+'&code='+code+'&cardType='+cardType,true);
					}else{
						Swiftpass.Alert('系统提示',rest.message);
						self.flag=0;
					}
				});
			}
		}},
		onClickBack:function(){
			Backbone.history.navigate('courtQueryNoticeA',true);
		},
		onClickpassword_button:function(e){
			var self = this, idcard = self.$('#idcard').val(), time = 60, target = $(e.currentTarget);
			if(target.hasClass('sending')){
				return;
			}else{
			  if(self.$('select[name=cardType]').val()=='请选择证件类型'){
				  Swiftpass.Alert('系统提示','请选择证件类型');
			  }else{
				if (!/^[1-9]([0-9]{16}|[0-9]{13})[xX0-9]$/.test(idcard) && (!/[a-zA-Z0-9]{8}-[a-zA-Z0-9]/.test(idcard)) 
					&& (!/^(P\d{7}|G\d{8}|S\d{7,8}|D\d+|1[4,5]\d{7})$/.test(idcard))) {
					Swiftpass.Alert('系统提示','请输入正确的证件号！');
					return ;
	        }else{
			target.addClass('sending');
			$.ajax({ type: 'POST', url: '/szlhfy/getCode', data: {idcard:idcard,cardType:$('select[name=cardType]').val()}, dataType: 'json', success: function(rest){
				if(rest.status){
					Swiftpass.Alert('系统提示',rest.message);
					target.text('重新发送(' + time + ')');
					
					self.interval = setInterval(function(){			
						if(Backbone.history.fragment !== 'courtPartyQueryA'){
							clearInterval(self.interval);
						}
						if(time > 0 ){
							$('#password_button').text('重新发送(' + (--time) + ')');
							$('#password_button').css("color","#CCC");
						}else{
							target.removeClass('sending');
							clearInterval(self.interval);
							self.$('#newcode').val("");
							target.text('获取密码');
							$('#password_button').css("color","#545454");
						}
					}, 1000);
				}else{
					target.removeClass('sending');
					Swiftpass.Alert('系统提示','验证码发送失败，请重试！');
					
				}
			}, error:function(XMLHttpRequest, textStatus, errorThrown){
				if(self.interval){
					target.removeClass('sending');
					clearInterval(self.interval);
				}
			},
			complete: function(XMLHttpRequest, textStatus){
				
			}});
		}}}},
		
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	
	// 审判流程公开>>>当事人查询>>>查询页面>>>查询结果
	var courtQueryContentC = Backbone.View.extend({
		el:'#court_query_content_02',
		events:{
			'click #go-here':'onClickGoHere',// 去这里
			'click #down':'onClickDown',
			'click #back':'onClickBack'// 返回
		},
		initialize:function(param){
			var self = this;
			$('body').removeClass('index_bg');
		},
		onClickBack:function(){
			var cardType = $("#court_query_content_02").attr("cardType");
			var idcard = $("#court_query_content_02").attr("idcard");
			var code = $("#court_query_content_02").attr("code");
			var infoTotal = $("#court_query_content_02").attr("infoTotal");
			if(infoTotal =='1'){
				  $.postJSON('/szlhfy/LogoutSecd',{},function(rest){
					  if(rest.status){
						Backbone.history.navigate('courtPartyQueryA',true);
					  	}else{
					  		Swiftpass.Alert('系统提示',rest.message);
						}
					});
			}else{
				Backbone.history.navigate('courtParty?idcard='+idcard+'&code='+code+'&cardType='+cardType,true);
			}
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	
	// 执行信息公开>>>社会公众查询
//	var CourtPublicQuery = Backbone.View.extend({
//		el:'#court_public_query',
//		events:{
//			'click #courtQueryContent':'onClickcourtQueryContent',// 查询页面
//			'click #down':'onClickDown',
//			'click #back':'onClickBack'
//		},
//		initialize:function(param){
//			this.flag=0;
//			var self = this;
//		},
//		onClickDown:function(){
//			$(document.body).scrollTop(400);
//		},
//		onClickBack:function(){
//			Backbone.history.navigate('courtRead',true);
//		},
//		onClickcourtQueryContent:function(e){
//			var self=this;
//			var caseNoyear ="("+self.$("#caseNoyear").find("option:selected").text()+")",
//				caseNotapye= "深罗法"+self.$("#caseSize").find("option:selected").text()+"字",
//				caseNos = "第"+self.$('#caseNos').val()+"号",
//				caseNo = caseNoyear+caseNotapye+caseNos;
//			if(caseNoyear=='请选择案件年份'){
//				Swiftpass.Alert('系统提示','请选择案件年份！');
//				return;
//			}else{
//			if(caseNotapye=='深罗法请选择案件字号字'){
//				Swiftpass.Alert('系统提示','请选择案件字号！');
//				return;
//			}else{
//			
//			if(caseNos == '第号'){
//				Swiftpass.Alert('系统提示','请输入案号！');
//				return;
//			}	
//			else{
//				if($(".caseNo").text() == ""){
//					$(".caseNo").text("您要查询的是："+caseNo);
//					self.$("#courtQueryContent").text("确 定");
//				}else{
//					if(self.flag == 0){
//						self.flag=1;
//						$.postJSON('/szlhfy/courtQueryContentIsOk',{caseNo:caseNo},function(rest){
//					if(rest.status){
//						Backbone.history.navigate('courtQueryContent?caseNo='+caseNo,true);				
//					}
//					else{
//						Swiftpass.Alert('系统提示',rest.message);
//						$(".caseNo").text("");
//						self.$("#courtQueryContent").text("查 询");
//						self.flag=0;
//				}				
//			});
//			}}}
//		  }
//		 }
//	}});
	
//	// 执行信息公开>>>社会公众查询>>>查询结果
//	var courtQueryContent = Backbone.View.extend({
//		el:'#court_query_content_04',
//		events:{
//			'click #go-here':'onClickGoHere',// 社会公众查询
//			'click #down':'onClickDown',
//			'click #back':'onClickBack'// 返回
//		},
//		initialize:function(param){
//			var self = this;
//		},
//		onClickBack:function(){
//			Backbone.history.navigate('courtPublicQuery',true);
//		},
//		onClickDown:function(){
//			$(document.body).scrollTop(400);
//		}
//	});
	
	// 当事人查询
	var courtQueryNotice = Backbone.View.extend({
		el:'#court_query_notice',
		events:{
			'click #go-here':'onClickGoHere',// 去这里
			'click #back':'onClickBack',// 返回
			'click #checkbox':'onClickcheckbox',// 复选框样式
			'click #Next':'onClickNext',// 下一步
			'click #down':'onClickDown'
		},
		initialize:function(param){
			$('body').removeClass('index_bg');
			var self = this;
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		},
		onClickcheckbox:function(){
			if($(".checkbox_sel").hasClass("on")){
				$(".checkbox_sel").removeClass("on");
				$(".button").addClass("no_next");
			}else{
				$(".checkbox_sel").addClass("on");
				$(".button").removeClass("no_next");
			}
		},
		onClickBack:function(){
			Backbone.history.navigate('courtRead',true);
		},
		onClickNext:function(){
			if($(".checkbox_sel").hasClass("on")){
				Backbone.history.navigate('courtPartyQuery',true);
			}else{
				Backbone.history.navigate('courtQueryNotice',true);
			}
		}
	});
	
	// 当事人查询>>>查询页面
	var courtPartyQuery = Backbone.View.extend({
		el:'#court_party_query',
		interval:undefined,
		events:{
			'click #courtQueryContentA':'onClickGocourtQueryContentA',// 查询结果
			'click #down':'onClickDown',
			'click #password_button':'onClickpassword_button',// 收取短信密码
			'click #back':'onClickBack'
		},
		initialize:function(param){
			$('body').removeClass('index_bg');
			var self = this;
		},
		onClickGocourtQueryContentA:function(){
			var idcard = self.$('#idcard').val(), code = self.$('#code').val(),cardType = self.$('select[name=cardType]').val();
			if(code == '' ){
				Swiftpass.Alert('系统提示','请输入密码！');
				return 
			}else{	
			$.postJSON('/szlhfy/courtPartyAjax',{idcard:idcard,code:code,cardType:cardType},function(rest){
				if(rest.status){
					Backbone.history.navigate('courtPartyA?idcard='+idcard+'&code='+code+'&cardType='+cardType,true);
				}else{
					Swiftpass.Alert('系统提示',rest.message);
				}				
			});
		}},
		onClickBack:function(){
			Backbone.history.navigate('courtQueryNoticeA',true);
		},
		onClickpassword_button:function(e){
			var self = this, idcard = self.$('#idcard').val(), time = 60, target = $(e.currentTarget);
			if(target.hasClass('sending')){
				return;
			}else{
		    	if(self.$('select[name=cardType]').val()=='请选择证件类型'){
		    		Swiftpass.Alert('系统提示','请选择证件类型');
				 }else{
		     	if (!/^[1-9]([0-9]{16}|[0-9]{13})[xX0-9]$/.test(idcard) && (!/^(P\d{7}|G\d{8}|S\d{7,8}|D\d+|1[4,5]\d{7})$/.test(idcard))
					&& (!/^(P\d{7}|G\d{8}|S\d{7,8}|D\d+|1[4,5]\d{7})$/.test(idcard))) {
		     		Swiftpass.Alert('系统提示','请输入正确的证件号！');
	            return ;
	        }else{
			target.addClass('sending');
			$.ajax({ type: 'POST', url: '/szlhfy/getCode', data: {idcard:idcard,cardType:$('select[name=cardType]').val()}, dataType: 'json', success: function(rest){
				if(rest.status){
					Swiftpass.Alert('系统提示',rest.message);
					target.text('重新发送(' + time + ')');
					
					self.interval = setInterval(function(){			
						if(Backbone.history.fragment !== 'courtPartyQuery'){
							clearInterval(self.interval);
						}
						if(time > 0 ){
							$('#password_button').text('重新发送(' + (--time) + ')');
							$('#password_button').css("color","#CCC");
						}else{
							target.removeClass('sending');
							clearInterval(self.interval);
							self.$('#newcode').val("");
							target.text('获取密码');
							$('#password_button').css("color","#545454");
						}
					}, 1000);
				}else{
					target.removeClass('sending');
					Swiftpass.Alert('系统提示','验证码发送失败，请重试！');
					
				}
			}, error:function(XMLHttpRequest, textStatus, errorThrown){
				if(self.interval){
					target.removeClass('sending');
					clearInterval(self.interval);
				}
			},
			complete: function(XMLHttpRequest, textStatus){
				
			}});
		}}}},
		
		onClickBack:function(){
			Backbone.history.navigate('courtQueryNotice',true);
		}, 
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	
	
	// 当事人查询>>>案件列表
	var courtguideList = Backbone.View.extend({
		el:'#court_guide_list',
		events:{
			'click #courtQueryContentA':'onClickGocourtQueryContentA',// 查询结果
			'click #down':'onClickDown',
			'click #back':'onClickBack'// 返回
		}, 	
		onClickGocourtQueryContentA:function(e){
			var id = $("#courtQueryContentA").attr("caseid");
			var cardType = $("#selectTab1").attr("cardType");
			var idcard = $("#selectTab1").attr("idcard");
			var code = $("#selectTab1").attr("code");
			var infoTotal = $("#selectTab1").attr("infoTotal");
			Backbone.history.navigate('courtQueryContentA?id='+id+'&idcard='+idcard+'&code='+code+'&cardType='+cardType+'&infoTotal='+infoTotal,true);
		},
		onClickBack:function(){
			  $.postJSON('/szlhfy/Logout',{},function(rest){
			  if(rest.status){
				Backbone.history.navigate('courtPartyQuery',true);
			  	}else{
			  		Swiftpass.Alert('系统提示',rest.message);
				}
			});
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	
	// 当事人查询>>>查询页面>>>查询结果
	var courtQueryContentA = Backbone.View.extend({
		el:'#court_query_content_03',
		events:{
			'click #go-here':'onClickGoHere',// 去这里
			'click #down':'onClickDown',
			'click #back':'onClickBack'// 返回
		},
		initialize:function(param){
			var self = this;
			$('body').removeClass('index_bg');
		},
		onClickBack:function(){
			var cardType = $("#court_query_content_03").attr("cardType");
			var idcard = $("#court_query_content_03").attr("idcard");
			var code = $("#court_query_content_03").attr("code");
			var infoTotal = $("#court_query_content_03").attr("infoTotal");
			if(infoTotal =='1'){
				  $.postJSON('/szlhfy/Logout',{},function(rest){
					  if(rest.status){
						Backbone.history.navigate('courtPartyQuery',true);
					  	}else{
					  		Swiftpass.Alert('系统提示',rest.message);
						}
					});
			}else{
				Backbone.history.navigate('courtPartyA?idcard='+idcard+'&code='+code+'&cardType='+cardType,true);
			}
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});

	// 文书列表
	var PartyListViewu = Backbone.View.extend({
		template:'<li><span class="s"></span><i></i></li>',
		className:'',
		events:{'click li' : 'goToViewu'},
		initialize:function(model, parent){
			this.parent = parent;
			this.render();
			$('body').removeClass('index_bg');
			this.$('.s').attr('ahdm',model['ahdm']);
			this.$('.s').attr('xh',model['xh']);
			this.$('.s').text(model['ah']);
		},
		goToViewu:function(e){
			var ahdm = this.$('.s').attr('ahdm'),xh = this.$('.s').attr('xh'),costName = self.$('select.cost_select').val();
			if($('.s').data('submiting')) return;
			$('.s').data('submiting',true);
			self.$('.pop-wraper-1').show();
			$.postJSON('/szlhfy/documentsPageIsok',{ahdm:ahdm,xh:xh,costName:costName},function(rest){
				  if(rest.status){
					  Backbone.history.navigate('documentsPage?costName='+costName+"&ahdm="+ahdm+"&xh="+xh,true);
				  	}else{
				  		self.$('.pop-wraper-1').hide();
				  		Swiftpass.Alert('系统提示',rest.message);
				  		$('.s').data('submiting',false);
					}
				});
			},
			render:function(){
			this.$el.html(this.template);
		},
	});
	
	var currentPage = 0;
	
	// 审判文书公开
	var courtJudicial = Backbone.View.extend({
		el:'#court_Judicial',
		events:{
			'click #courtJudicial':'onClickcourtJudicial',
			'click .p_more':'onClickcourtJudicial',
			'click #down':'onClickDown'
		},
		initialize:function(param){
			this.flag=0;
			var self = this;
			$('body').removeClass('index_bg');
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		},
		onClickcourtJudicial:function(e){
			var self = this;
			if(e.target.id == 'courtJudicial'){
				self.$('.Judicial_list').html('');
				currentPage = 0;
			}
			var  caseNo = self.$('#caseNo').val(), costName = self.$('select.cost_select').val();
			if(caseNo == ''){
				Swiftpass.Alert('系统提示','请输入案号！');
				return false;
			}
			if(caseNo.indexOf("20") == 0 ){ 
				Swiftpass.Alert('系统提示','由于系统原因，请您勿输入年份,请重新输入！');
				return false;
			} 		
//			if(caseNo.indexOf("字") == -1 ){ 
//				Swiftpass.Alert('系统提示','请输入正确的案号！');
//				return;
//			}
			else{	
				$.postJSON('/szlhfy/courtJudicialIsok',{caseNo:caseNo,costName:costName,page:currentPage},function(rest){
					if(rest.status){
						var json = rest.message;
						if(json.length > 0){
							var html = '';
							for ( var int = 0; int < json.length-1; int++) {
								var partyList = new PartyListViewu(json[int]);
								partyList.$el.appendTo(self.$('.Judicial_list'));
							}
							self.$('#court_party_queryA_w').html(html);
							
							if(json[json.length-1]['isMore'] == 'true'){
								self.$('.p_more').show();
							}else{
								self.$('.p_more').hide();
							}
							currentPage = json[json.length-1]['currentPage'];
						}
					}else{
						Swiftpass.Alert('系统提示',rest.message);
					}				
				});
		 }
		},
		
		onClickcourtQueryNotice:function(e){
			Backbone.history.navigate('courtQueryNotice',true);
		}
	});
	// 文书页面
	var documentsPage = Backbone.View.extend({
		el:'#documents',
		events:{
			'click #down':'onClickDown',
			'click #back':'onClickBack'
		},
		initialize:function(param){
			$('body').removeClass('index_bg');
			var self = this;
		},
		onClickBack:function(){
			Backbone.history.navigate('courtJudicial',true);
		},
		onClickDown:function(){
			$(document.body).scrollTop(400);
		}
	});
	
	/**
	 * 首页
	 */
	var HomePage = Backbone.View.extend({
		el:'#court_index',
		events:{
			'click #call_judge':'searchJudge',// 法官查询
			'click #navigation':'navigation',// 交通导航
			'click #courtRead':'courtRead',// 执行信息公开
			'click #courtReadA':'courtReadA',// 审判流程公开
			'click #courtJudicial':'courtJudicial'// 审判文书公开
		},
		initialize:function(param){
			var self=this;
			$(document).ready(function(){
				//var swipePosition = $(".swipe_position li");
				window.mySwipe = $('#mySwipe').Swipe({
					continuous: true,//是否无限滚动
					disableScroll: false,
					stopPropagation: false,
					//callback: function(index, elem) {
						//$(".swipe_position li").removeClass('on');
						//swipePosition[index].className='on';
					//},
					auto:3000,
				});

			});
			this.routes = new skipRouter('#wft_ctn',this);
			Backbone.history.start(false);
		},
		searchJudge:function(e){// 法官查询页
			Backbone.history.navigate('searchJudge',true);
		},
		courtRead:function(e){// 执行信息公开
			Backbone.history.navigate('courtRead',true);
		},
		courtReadA:function(e){// 执行信息公开
			Backbone.history.navigate('courtReadA',true);
		},
		courtJudicial:function(e){// 审判文书公开
			Backbone.history.navigate('courtJudicial',true);
		},
		navigation:function(e){// 法官查询页
			Backbone.history.navigate('navigation',true);
		}
	});
	
	// 注册Routes页面
	var AppRouter = Backbone.Router.extend({
	  navigateTo:function(name,param){// 自定义导航
			if(param.length > 0){
				param = $.urlParam(param);
			}
			var pageCall = this[name];
			if(!pageCall){
				pageCall = this['home'];
			}
			
			if(pageCall && $.isFunction(pageCall)){
				pageCall.call(this,param || {});
			}
	  },
	  home:function(param){
		  new HomePage(param);
	  }
	});
	
	/**
	 * 页面加载器
	 */
	var Loding = Backbone.View.extend({
		template:'<div id="loading"><img src="/assets/images/loading.gif"/><div id="loading-text"></div></div>',
		id:'page-loading',
		initialize:function(p){
			this.render(p);
		},
		render:function(p){
			this.$el.html(this.template);
			if(p)this.$el.appendTo(p);
		}
	});
	Loding.show = function(){
		if(Loding._loading){
			Loding._loading.$el.appendTo($('body'));
		}else{
			Loding._loading = new Loding($('body'));
		}
	},
	Loding.hide = function(){
		if(Loding._loading){
			Loding._loading.$el.remove();
		}
	},
	
	
	jQuery(function(){
		// 初始化执行
		var appRouter = new AppRouter();
		var page = location.pathname.replace(/^\//,'');
		if($.trim(page).length == 0){
		  var fegments = /#(.*)/.exec(location.href);
		  page = 'home'
		  if(fegments && fegments.length == 2){
			  page = fegments[1];
		  }
		}
		var param = location.search.replace(/^\?/,'');
		appRouter.navigateTo(page,param);
	});	
})(window);