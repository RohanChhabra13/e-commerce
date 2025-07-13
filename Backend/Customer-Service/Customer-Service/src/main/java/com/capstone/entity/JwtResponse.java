package com.capstone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {

	private String jwtToken;
	private String custid;
	
	public static Builder builder() {
        
        return new Builder();
    }

    public static class Builder {
        private String jwtToken;
        private String custid;

        private Builder() {
        }

        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public Builder custid(String custid) {
            this.custid = custid;
            return this;
        }

        public JwtResponse build() {
            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.jwtToken = this.jwtToken;
            jwtResponse.custid = this.custid;
            return jwtResponse;
        }
    }
	
}
