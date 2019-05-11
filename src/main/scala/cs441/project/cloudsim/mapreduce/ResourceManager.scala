package cs441.project.cloudsim.mapreduce

import com.typesafe.config.Config
import cs441.project.cloudsim.Job
import org.cloudbus.cloudsim.brokers.DatacenterBroker
import org.cloudbus.cloudsim.cloudlets.Cloudlet
import org.cloudbus.cloudsim.cloudlets.network.NetworkCloudlet
import org.cloudbus.cloudsim.vms.Vm

/**
  * Models a resource manager, which takes in the Job requests allocated/schedules the jobs among the different available nodes.
  *
  */

class ResourceManager extends Job {

  val mapper = new Mapper
  val reducer = new Reducer

  def allocateMappers(numberOfMappers: Int, inputSplitSize: Int): List[NetworkCloudlet] = {


  }

  def allocateReducers(numberOfReducers: Int): List[NetworkCloudlet] = {}

  /**
    * Receives the Job requests and schedules the job tasks among the worker nodes.
    *
    * @param jobConf Job config describing the hadoop job to run on the cluster
    */

  def receiveJobRequest(job: String): Unit = {


    val inputFileSize = ConfigLoader.INPUT_FILE_SIZE
    val inputSplitSize = ConfigLoader.INPUT_SPLIT_SIZE

    // Decide on the number mappers and reducers based on the Input file size and the split size

    val numberOfMappers, numberOfReducers = inputFileSize / inputSplitSize

    // Allocate mappers job
    val mappers = allocateMappers(numberOfMappers, inputSplitSize)

    //Allocate reducers job
    val reducers = allocateReducers(numberOfReducers)


    //Define the Vms/Resources on which mappers and reducers are simulated


  }


  /**
    * The config ID for a simulation of this job type.
    *
    * @param configId The ID representing the variation of this job type that is to be simulated.
    * @param broker   Reference to the datacenter broker that the job may use for dynamic creation/submission of
    *                 cloudlets and VMs.
    */
  override def setSimulation(configId: Int, broker: DatacenterBroker): Unit = ???

  /**
    * The VMs that this job needs for its execution.
    *
    * This method should create the necessary [[Vm]] objects along with the required configuration.
    *
    * @return List of VMs
    */
  override def getVmList: List[Vm] = ???

  /**
    * The cloudlets that this job needs to complete its execution.
    *
    * This method should create the necessary [[Cloudlet]]s along with the required configuration.
    *
    * @return List of Cloudlets
    */
  override def getCloudletList: List[Cloudlet] = ???
}
