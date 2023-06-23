package pl.edu.pwr.party_organizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import pl.edu.pwr.party_organizer.model.Guest;
import pl.edu.pwr.party_organizer.model.Party;
//put some aspects
//stedentAPI example

@ComponentScan(basePackages = {"pl.edu.pwr.party_organizer"})
@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
public class PartyOrganizerApplication {

	public static void main(String[] args) {
		// Guests g = new Guests("andrej","wad@de.vv");
		
		
		// Party p = new Party("haloween",1L,"wroclaw");
		SpringApplication.run(PartyOrganizerApplication.class, args);
	}

	@Bean
    public CorsFilter corsFilter() {

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:4200");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

}
