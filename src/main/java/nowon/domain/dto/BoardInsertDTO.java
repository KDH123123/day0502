package nowon.domain.dto;

public class BoardInsertDTO {
	
	private String subject;
	private String content;
	private String writer;
	
	public BoardInsertDTO() {
	}
	
	public BoardInsertDTO(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
