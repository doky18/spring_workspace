/**
	[받은 채팅관련 div 디자인]
 닫는 div는 할 필요가 없음
							<div class="chat-message-left pb-4">
							
								<div>
									<img src="https://bootdey.com/img/Content/avatar/avatar3.png" class="rounded-circle mr-1" alt="전송한사람이름" width="40" height="40">
									<div class="text-muted small text-nowrap mt-2">  전송받은시간  </div>
								</div>
								
								<div class="flex-shrink-1 bg-light rounded py-2 px-3 ml-3">
									<div class="font-weight-bold mb-1">  전송한사람이름  </div>
										<spen>전송받은 내용</spen>
								</div>
								
							</div>

 */
class MessageLeftCard {
	constructor(profile, name, time, content) {
		
		/*큰 div*/
		this.div = document.createElement("div");
		this.div.className = "chat-message-left pb-4";
		
		/*이미지, 전송받은 시간감싸는 div*/
		this.divSide = document.createElement("div");
		this.img = document.createElement("img");
		this.img.src = profile;
		this.img.className = "rounded-circle mr-1";
		this.img.alt = name;
		this.img.style.width="40px";
		this.img.style.height="40px";
		this.divTime = document.createElement("div");
		this.divTime.className = "text-muted small text-nowrap mt-2";
		this.divTime.innerHTML = time;
		
		/*전송한사람이름,내용받는 div*/
		this.divContent = document.createElement("div");
		this.divContent.className = "flex-shrink-1 bg-light rounded py-2 px-3 ml-3";
		this.divName = document.createElement("div");
		this.divName.className = "font-weight-bold mb-1";
		this.divName.innerHTML = name;
		this.spen = document.createElement("spen");
		this.spen.innerHTML = content;
		
		//부착하기
		this.div.appendChild(this.divSide);
		this.div.appendChild(this.divContent);
		
		this.divSide.appendChild(this.img);
		this.divSide.appendChild(this.divTime);
		
		this.divContent.appendChild(this.divName);
		this.divContent.appendChild(this.spen);

	}
	getBox() {
		return this.div;

	}
}
