# eRezept-Referenzvalidator ChangeLog

# 0.9.9 - 2022-04-04
- Update HAPI version from 5.6.0 to 5.7.2
- Set HAPI options
  - setAnyExtensionsAllowed(false)
  - setErrorForUnknownProfiles(true)
  - setNoExtensibleWarnings(true)
- Update externe ValueSets & Codesysteme (KBV) -> new package dav.kbv.sfhir.cs.vs-1.0.3-json.tgz
- Add new packages 
  - de.abda.erezeptabgabedatenbasis-1.2.0.tgz
  - de.abda.erezeptabgabedaten-1.2.0.tgz
  - de.gkvsv.erezeptabrechnungsdaten-1.2.0.tgz


# 0.9.8 - 2022-01-21
- Exchange Package de.abda.erezeptabgabedatenbasis-1.1.2.tgz with de.abda.erezeptabgabedatenbasis-1.1.3.tgz (KorrekturRelease) 
- Exchange Package de.abda.erezeptabgabedaten-1.1.1.tgz with de.abda.erezeptabgabedaten-1.1.2.tgz (KorrekturRelease)

# 0.9.7 - 2022-01-20
- Add valid & invalid TestBsp
- Add Package de.abda.erezeptabgabedatenbasis-1.1.2.tgz (KorrekturRelease)
- Exchange Package de.abda.erezeptabgabedaten-1.1.0.tgz with de.abda.erezeptabgabedaten-1.1.1.tgz (KorrekturRelease)

## 0.9.6 - 2022-01-06
- FIX Constraint Issue in "de.abda.erezeptabgabedatenbasis-1.1.0.tgz"
  - Error: Datatype (string) is case sensitiv but used with "Sting" in constraint
    - replace with "exists()" because string must have a value
  - DAV_EX_ERP_Rezeptaenderung - Rezeptaenderung-1 (on extention)
    - error Expression: "(extension('ArtRezeptaenderung').value as CodeableConcept).coding.code.matches('2|3|4|12') implies ((extension('DokumentationRezeptaenderung').value as String).length() > 0)"
    - new Expression: "(extension('ArtRezeptaenderung').value as CodeableConcept).coding.code.matches('2|3|4|12') implies extension('DokumentationRezeptaenderung').exists()"
  - DAV-EX-ERP-Zusatzattribute - PreisguenstigesFAM-1 (on Extension.extension:ZusatzattributFAM.extension:PreisguenstigesFAM)
    - error Expression: "(extension('Schluessel').value as CodeableConcept).coding.code.matches('4') implies ((extension('DokumentationFreitext').value as String).length() > 0)"
    - new Expression: "(extension('Schluessel').value as CodeableConcept).coding.code.matches('4') implies extension('DokumentationFreitext').exists()"
  - DAV-EX-ERP-Zusatzattribute - ImportFAM-1 (on Extension.extension:ZusatzattributFAM.extension:ImportFAM)
    - error Expression: "(extension('Schluessel').value as CodeableConcept).coding.code.matches('4') implies ((extension('DokumentationFreitext').value as String).length() > 0)"
    - new Expression: "(extension('Schluessel').value as CodeableConcept).coding.code.matches('4') implies extension('DokumentationFreitext').exists()"
  - DAV-EX-ERP-Zusatzattribute - Rabattvertragserfuellung-1 (on Extension.extension:ZusatzattributFAM.extension:Rabattvertragserfuellung)
    - error Expression: "(extension('Schluessel').value as CodeableConcept).coding.code.matches('4') implies ((extension('DokumentationFreitext').value as String).length() > 0)"
    - new Expression: "(extension('Schluessel').value as CodeableConcept).coding.code.matches('4') implies extension('DokumentationFreitext').exists()"
  + additional fix (DAV-PR-Base-ZusatzdatenHerstellung)
    - Fix identifier for actor in ZusatzdatenHerstellung by removing not-allowed multiple profiles in type definition and adding constraints
      - Expression: "conformsTo("http://fhir.abda.de/eRezeptAbgabedaten/StructureDefinition/DAV-PR-ERP-DAVHerstellerSchluessel") or conformsTo("http://fhir.de/StructureDefinition/identifier-iknr")"
      - Expression: "conformsTo("http://fhir.de/StructureDefinition/identifier-iknr") implies value.matches('[0-9]{9}')

## 0.9.5 - 2021-12-28
- Add fix for circular dependencies
- Add more profiles versions in packages
- Improve whitelisting
- Add valid and invalid testing files

## 0.9.4 - 2021-12-17
- Entfernung der Versionen aus Input-Instanzen und Profilen deaktiviert
- Speicherverbrauch reduziert
- Preload/Warm-up für Validator implementiert

## 0.9.3 - 2021-12-13
- Update Log4j -> 2.15.0 Behebung kritischen Sicherheitslücke (CVE-2021-44228)
