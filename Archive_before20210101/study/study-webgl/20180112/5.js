var VSHADER_SOURCE = `
	attribute vec4 a_Position;
	void main() { 
		gl_Position = a_Position;
		gl_PointSize = 10.0;
	}
`
var FSHADER_SOURCE = `
	void main(){
		gl_FragColor = vec4(1.0,0.0,0.0,1.0);
	}
`

function main(){
	var canvas = document.getElementById("webgl");
	
	var gl = getWebGLContext(canvas);
	
	if(!gl){
		console.log('error init gl');
		return;
	}
	
	if(!initShaders(gl,VSHADER_SOURCE,FSHADER_SOURCE)){
		console.log('error init sharders');
		return;
	}
	
	var a_Position = gl.getAttribLocation(gl.program,'a_Position');
	
	if(a_Position < 0){
		cosole.log('error init a_position');
		return;
	}
	
	//gl.vertexAttrib3f(a_Position,0.0,0.0,1.0);
	gl.vertexAttrib3f(a_Position,0.5,0.0,1.0);
	
	gl.clearColor(0.0,0.0,0.0,1.0);
	
	gl.clear(gl.COLOR_BUFFER_BIT);
	
	gl.drawArrays(gl.POINTS,0,1);
}