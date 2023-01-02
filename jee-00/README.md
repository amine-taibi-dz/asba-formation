# jee-00


Run a full build including integration-tests with:

```mvn verify```

The command will not only build the project, but also deploy it and run integration/system-tests.

See the docker-compose.yml files for various application-servers. The default being used in the docker-compose.yml is Wildfly. But to e.g. test against Websphere Liberty, just run:

```mvn install -DcomposeFile=docker-compose.wlp.yml```

Somebody said Websphere Traditional is hard? Just test your app on it like this:

```mvn install -DcomposeFile=docker-compose.was.yml```