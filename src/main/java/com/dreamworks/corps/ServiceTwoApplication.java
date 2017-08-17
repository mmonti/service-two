package com.dreamworks.corps;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.Tracer;
import com.uber.jaeger.propagation.TextMapCodec;
import com.uber.jaeger.samplers.ProbabilisticSampler;
import io.opentracing.propagation.Format;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTwoApplication.class, args);
	}

	@Bean
	public io.opentracing.Tracer jaegerTracer(){
		Tracer.Builder tracerBuilder =  new com.uber.jaeger.Configuration("service-two",
				new com.uber.jaeger.Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
				new com.uber.jaeger.Configuration.ReporterConfiguration())
//				new Configuration.ReporterConfiguration(Boolean.TRUE,"10.35.16.64", 6831, 1000, 100))
				.getTracerBuilder();

		TextMapCodec httpCodec = new TextMapCodec(false);
		tracerBuilder.registerInjector(Format.Builtin.HTTP_HEADERS, httpCodec);

		return tracerBuilder.build();
	}
}
