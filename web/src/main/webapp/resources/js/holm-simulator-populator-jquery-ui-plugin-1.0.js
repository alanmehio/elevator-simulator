/*!
 * jQuery UI Simulator Populator 1.0
 * http://kone.com
 *
 *  
 * This is a priority UI plugin
 * for further details please refer to 
 * http://holmconsulting.net
 * contributor : Alan Mehio
 */

 (function($) {
   $.widget( "holm.simulatorUI", {
	version: "1.0",
	options: {
		globalAjaxURL: 'elevator-simulator',
		user: 'user',
		password:'password',
		queue: '/topic/elevator', // subscription queue 
		data: null,

		 pushed: null,    // data is pushed now
		 stopped: null,   // simulator has been stopped
		 resumed:null,   // simulator has been resumed
		 cancelled:null, // simulator has been cancelled
		 counter: null, // the current simulator counter
		 firstData: null, // the first data which is pushed
		 lastData: null, // the last data before cancellation or stop signal
	},

	_create: function() {
		 console.log("created called");
		var socket = new SockJS('/elevator-simulator/elevator/start');
		var client = Stomp.over(socket);
		client.ui = this;
		var queue = this.options.queue

		client.connect(this.options.user, this.options.password, function(frame) {
			 console.log('Connected: '); 
	     client.subscribe(queue, function(dto) {
	    	 console.log('pushed data ' + dto);
			 client.ui.display(JSON.parse(dto.body));
	     });
	  
      });
	
	
	  },

	_destroy: function() {
		this.element.find(".fa").removeClass();
	},

	display: function( data ) {
		if ( data === undefined ) {
			return this.options.data;
		}

		this.options.data = this._constrainedValue( data );
		
		this._refreshValue();
		
	},

	_constrainedValue: function( data ) {
		return data;
	},

	_setOptions: function( options ) {
		// Ensure "data" option is set after other values
		var data = options.data;
		delete options.data;

		this._super( options );

		this.options.data = this._constrainedValue( data );
		this._refreshValue();
	},

	_setOption: function( key, value ) {
		
	},

	

	_refreshValue: function() {
		var data = this.options.data;
		this._cleanValue(data.id);
		this._displayData(data);
		
		
	},
	
	_cleanValue: function(id) {
	     $("#" + id +"-door").removeClass();
		 $("#" + id + "-direction").removeClass();
		 $("#" + id + "-floor").text("");
		 $("#" + id + "-weight").text("");
		 $("#" + id + "-date").text("");
	},
	
	_displayData: function(data) {
		 console.log(data);
	     if(data.door == 1) {
	        $("#" + data.id +"-door").addClass("glyph-icon flaticon-building72");
		 }else {
		  $("#" + data.id +"-door").addClass("glyph-icon flaticon-opened38");
		 } 
		
		
		if(data.direction == 1) {
		  $("#" + data.id + "-direction").addClass("fa fa-long-arrow-up");
		}else {
		  $("#" + data.id + "-direction").addClass("fa fa-long-arrow-down")
		}
		
		$("#" + data.id + "-floor").text(data.floor);
		
		$("#" + data.id + "-weight").text(data.weight);
		
		 $("#" + data.id + "-date").addClass("fa fa-clock-o");
		 $("#" + data.id + "-date").text(data.date);
		
		
	}
 });

})(jQuery);
