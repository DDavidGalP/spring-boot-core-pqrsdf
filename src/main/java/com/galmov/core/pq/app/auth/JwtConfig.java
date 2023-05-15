package com.galmov.core.pq.app.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEowIBAAKCAQEAted2xJFputlJDdCzub6lGyOj0pZJlymhicG6NHRMpxZvnUfG\r\n"
			+ "A5f9IJy7wG8jOpL128NmFU1WHzOKKdp/kXp4bupdb09/fzAK3vUiWRaa88gSPQLV\r\n"
			+ "22QwUQhl3+wPx1GQmvGKpngaMaNTeS7BhoN1QZvD8mH4trUoSsrJyEHi8sOpkhoh\r\n"
			+ "3rsyQyDE+rqarOS+v8w64GBoDhtL3CnzNUdBOC4gUvTzKe/7UJNyyTGQ4lDRsQx3\r\n"
			+ "CTLCb1RFNw7gBvAVOq9DIc9lWS2L3dRDGzsL/5Rarq0hgbjClJ0RBBmW+iiYQ3Rx\r\n"
			+ "aesX6wgpinxggjb0JDOc/qtD4k3Fkmz3RTglBwIDAQABAoIBAHjYBkzcFZNt2lx1\r\n"
			+ "M5DIGEOJT8IM2WK0433y11MVl/7ApvGjxuaISD8sIIbczliRXQfcLaslL3uW78iS\r\n"
			+ "QYFSDUQSKnRSKe9C6VXpICJzJAmj9onVomEXlAmhPJyf5HOTui9VG7kvvKcRS9kL\r\n"
			+ "uME1/+XQJ0KU13f5rYTSZ27EZpLDTtk6XOfi68Q36duymgShnqnkjoUUW/qIXlo7\r\n"
			+ "qbTISWcbB1DXwspQY/dasqZpbhaWwdPPXjhvbbbMfVwjo9U6hb4hX7t+PcZeBfLu\r\n"
			+ "qSFRanOrFBZs8lQiVuAk21MRQl/JTxApbYidGAj76n9I7vIHkmtxJmZXbOZn43SF\r\n"
			+ "x97YdwECgYEA2vWB3q24ksdFufcYuv4+LeuCc4PfEP5pU+U3YZiO2Wg0lqAmJ8ui\r\n"
			+ "id+xHbtWmq5XtUHS/ju69mz2+jHvsujsAXsvNtY8gwTjX9PZ3bWCf7kkwII3+gCG\r\n"
			+ "v+OU2BQl6HLEUucT8HcoIt4AXBEb/E7cTmJqcM/YxUk18Exu95Y46EcCgYEA1K03\r\n"
			+ "UERVKtfOxu1PNysPZalnlmhCiUtKwlANQJKPU8n5hg29hXepWz1oSeAw/mlJiMBE\r\n"
			+ "LFRa/AL2hdnN7XrJh+twrcCzssfX10q8aNrYgDQC0zw+ua9WSJ/dRE89Cv2IbW4D\r\n"
			+ "iz/qCAfkR3m1iwaj35X+pUDi6mzNB5FdkZWR/UECgYEA01TeEiSt3s0CmWjKr8Cw\r\n"
			+ "FvYWJJQE+ovy8QxtFX9/cIrJJxBPg11h9Zy3gDDOd+EJumJb2RGhdDLbdcQ4y/9P\r\n"
			+ "umZAvbatFO/k3RrGTtzfpZL2y+9jQ6K6a/6mLJ/VrrMGldV+Qzteu7h1tGa3EiCz\r\n"
			+ "Ndx7S4LwgAoXS2UaPVD6gAUCgYBs9kYVqLzd022Me78PK8+arV12MPqN7vZhcbQo\r\n"
			+ "di5apmtiJB4KiJFLPr30w5k2b2kOWDtVXu6ymS4Gy912o2cnbRfw3X7zxPGvywmW\r\n"
			+ "yzELFhqwcPhOGCgj00wBGHvU6qqALlJAgMF91dU+TXwWu5MwFWA++GyJ4K53ByIi\r\n"
			+ "WbhPQQKBgCuS57NuVwrgO4V+Gv8pF9foimW9wrdfd3N+v2spiFjv3A42jo9iaH6S\r\n"
			+ "qQyOghJhqtblNbd2yErkOUjQoAVsRBmNXfeUbNXMKa9mrncTNxoLs4nAHG9SPLOf\r\n"
			+ "1BNohs1bqRuYHSRXsEs6qxzX+M5CPwN7YlSS67v6faFOl8LYrNQd\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAted2xJFputlJDdCzub6l\r\n"
			+ "GyOj0pZJlymhicG6NHRMpxZvnUfGA5f9IJy7wG8jOpL128NmFU1WHzOKKdp/kXp4\r\n"
			+ "bupdb09/fzAK3vUiWRaa88gSPQLV22QwUQhl3+wPx1GQmvGKpngaMaNTeS7BhoN1\r\n"
			+ "QZvD8mH4trUoSsrJyEHi8sOpkhoh3rsyQyDE+rqarOS+v8w64GBoDhtL3CnzNUdB\r\n"
			+ "OC4gUvTzKe/7UJNyyTGQ4lDRsQx3CTLCb1RFNw7gBvAVOq9DIc9lWS2L3dRDGzsL\r\n"
			+ "/5Rarq0hgbjClJ0RBBmW+iiYQ3RxaesX6wgpinxggjb0JDOc/qtD4k3Fkmz3RTgl\r\n"
			+ "BwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
