package com.tcs.main;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.tcs.model.Student;

public class SpringAnnotationMain {
	public static void main(String args[]) {
		Student stud = new Student("Jon", "12");
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("getName()");
		EvaluationContext context = new StandardEvaluationContext(stud);
		System.out.println((String) exp.getValue(context));
	}
}
