2023-11-28T13:26:40.306+05:30 ERROR 15008 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Infinite recursion (StackOverflowError)] with root cause

java.lang.StackOverflowError: null
	at java.base/java.lang.ClassLoader.defineClass1(Native Method) ~[na:na]
	at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1013) ~[na:na]
	at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:150) ~[na:na]
	at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:862) ~[na:na]
	at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:760) ~[na:na]
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:681) ~[na:na]
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:639) ~[na:na]
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]


 @GetMapping("getMedicalRecord/{doctorId}")
    public ResponseEntity<List<PatientMedicalRecord>> getListOFPatientMedicalRecord(@PathVariable Long doctorId){
        return patientMedicalRecordService.getListOfPatientMedicalRecordForDoctor(doctorId);
    }

    #method getListOFPatientMedicalRecord() working fine for doctor buttttt
    
    @GetMapping("getMedicalRecord/{patientId}")
    public ResponseEntity<List<PatientMedicalRecord>> getPatientMedicalRecord(@PathVariable long patientId){
        return patientMedicalRecordService.getListOfPatientMedicalRecordForPatient(patientId);
    }

    ##this method is not working for patients
