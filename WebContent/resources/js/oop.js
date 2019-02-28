function People(name,age,gender,job){
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.job = job;
}
People.prototype.setName =name=>{this.name = name;};
People.prototype.setAge =age=>{this.age = age;};
People.prototype.setGender =gender=>{this.gender = gender;};
People.prototype.setJob =job=>{this.job = job;};
People.prototype.getName =()=>{return this.name;};
People.prototype.getAge =()=>{return this.age;};
People.prototype.getGender =()=>{return this.gender;};
People.prototype.getJob =()=>{return this.job;};


function Customer(grade,custNo){
	People.apply(this,arguments);
	this.grade = grade;
	this.custNo = custNo;
	
}
Customer.prototype = new People();

//다형성
Customer.prototype.setName =name=>{
	//this.name='[닉네임]'+name;  이건 자바 문법 
	Object.getPrototypeOf(Customer.prototype).setName('[닉네임]'+name);
};
Customer.prototype.setGrade =grade=>{this.grade = grade;};
Customer.prototype.setCustNo =custNo=>{this.custNo = custNo;};
Customer.prototype.getGrade =()=>{return this.grade;};
Customer.prototype.getCustNo =()=>{return this.custNo;};

//추상화
var test = {main:()=>{
		let cust = new Customer();
		cust.setName('홍길동');
		cust.setAge('25세');
		cust.setGender('남');
		cust.setJob('개발자');
		cust.setGrade('3급');
		cust.setCustNo('123');
		alert('[고객정보] \n'+cust.getName()+'\n'
				+cust.getAge()+'\n'
				+cust.getGender()+'\n'
				+cust.getJob()+'\n'
				+cust.getGrade()+'\n'
				+cust.getCustNo());
	}};
	


