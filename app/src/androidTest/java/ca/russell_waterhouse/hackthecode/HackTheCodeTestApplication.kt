package ca.russell_waterhouse.hackthecode

import ca.russell_waterhouse.hackthecode.dependency_injection.ContextModule

class HackTheCodeTestApplication: HackTheCodeApplication() {
    override val appComponent = DaggerTestApplicationComponent.builder().contextModule(ContextModule(this)).build()
}