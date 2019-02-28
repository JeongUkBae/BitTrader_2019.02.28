package proxy;

import javax.servlet.http.HttpServletResponse;

import lombok.Data;
@Data
public class ResponseProxy implements Proxy{
	private HttpServletResponse response;

	@Override
	public void carryOut(Object o) {
		System.out.println("----4----");
		if((HttpServletResponse)o != null) {
			System.out.println("o가 널 아님");
			setResponse((HttpServletResponse)o);
		}else {
			System.out.println("o가 널");
		}
		
	}
}
