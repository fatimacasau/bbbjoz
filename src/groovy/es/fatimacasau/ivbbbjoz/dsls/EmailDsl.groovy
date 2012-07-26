package es.fatimacasau.ivbbbjoz.dsls

import org.apache.commons.lang.WordUtils;

class EmailDsl {
	
	String toText
	String fromText
	String body
	def sections = []

	/**
	 * @param closure
	 * @return closure -> Delegate the closure methods to the DSL class
	 */
	def static print(closure) {
		EmailDsl emailDsl = new EmailDsl()
		closure.delegate = emailDsl
		closure()
	}

	def to(String toText) {
		this.toText = toText
	}

	def from(String fromText) {
		this.fromText = fromText
	}

	def body(String bodyText) {
		this.body = bodyText
	}

	/**
	 * @description When a method is not recognized, assume it is a title for a new section. Create a simple
	 * object that contains the method name and the parameter which is the body.
	 * @param methodName -> new section
	 * @param args -> section value
	 */
	def methodMissing(String methodName, args) {
		def section = new Section(title: methodName, body: args[0])
		sections << section
	}

	def getText() {
		doText()
	}
	
	private doText() {
		def template = """Email
To: ${toText}
From: ${fromText}
Body: ${body}
"""
		sections.each{ s->
			template += "${WordUtils.capitalize(s.title)}: ${s.body}"
		}
		println template
	}

}

class Section {
	String title
	String body
}