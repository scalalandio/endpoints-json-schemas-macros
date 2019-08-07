package io.scalaland.endpoints.macros

import utest._

object JsonSchemasMacrosTest extends TestSuite {

  import TestJsonSchemas._
  import TestJsonSchemas.JsonSchemas._


  val tests = Tests {

    "macros derive JsonSchema for primitives" - {

      genericJsonSchema[String] ==> "string"
      genericJsonSchema[Int] ==> "int"
      genericJsonSchema[Long] ==> "long"
      genericJsonSchema[BigDecimal] ==> "bigdecimal"
      genericJsonSchema[Float] ==> "float"
      genericJsonSchema[Double] ==> "double"
      genericJsonSchema[Boolean] ==> "boolean"
      genericJsonSchema[Byte] ==> "byte"
    }

    "macros derive JsonSchema for case class" - {

      fooSchema ==> "'ExampleDomainFoo'!(bar:string,baz:int,qux:boolean?)"
    }

    "macros derive JsonSchema for sequence types" - {

      listIntSchema ==> "[int]"
      seqFooSchema ==> "['ExampleDomainFoo'!(bar:string,baz:int,qux:boolean?)]"
    }

    "macros derive JsonSchema for records" - {

      fooSchema ==> "'ExampleDomainFoo'!(bar:string,baz:int,qux:boolean?)"

      quuxASchema ==> "'ExampleDomainQuuxA'!(ss:['ExampleDomainFoo'!(bar:string,baz:int,qux:boolean?)])"
      quuxBSchema ==> "'ExampleDomainQuuxB'!(i:int)"
      quuxCSchema ==> "'ExampleDomainQuuxC'!(b:boolean)"
      quuxDSchema ==> "'ExampleDomainQuuxD'!($)"
      quuxESchema ==> "'ExampleDomainQuuxE'!($)"
    }

    "macros derive JsonSchema for sum types" - {

      singleCaseBaseSchema ==> "'ExampleDomainSingleCaseBase'!('ExampleDomainSingleCaseInst'!(foo:string)@SingleCaseInst)"
      quuxSchema ==> "'ExampleDomainQuux'!('ExampleDomainQuuxA'!(ss:['ExampleDomainFoo'!(bar:string,baz:int,qux:boolean?)])@QuuxA|'ExampleDomainQuuxB'!(i:int)@QuuxB|'ExampleDomainQuuxC'!(b:boolean)@QuuxC|'ExampleDomainQuuxD'!($)@QuuxD|'ExampleDomainQuuxE'!($)@QuuxE)"
    }

    "macros derive JsonSchema for generic types" - {

      idSchema[Int] ==> "string"
      idSchema[Float] ==> "string"
      idSchema[Foo] ==> "string"

      userSchema[Int] ==> "'ExampleDomainUser'!(id:string,name:string)"
      userSchema[Float] ==> "'ExampleDomainUser'!(id:string,name:string)"
      userSchema[Foo] ==> "'ExampleDomainUser'!(id:string,name:string)"
    }
  }
}
